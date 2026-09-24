package com.example.ui.reader

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.ExerciseAnswerEntity
import com.example.data.model.Chapter
import com.example.data.model.ChapterSection
import com.example.data.preferences.ReaderFontFamily
import com.example.data.preferences.ReaderFontSize
import com.example.data.preferences.ReaderSettings
import com.example.data.preferences.ReaderThemeMode
import com.example.ui.components.ChapterNavigationFooter
import com.example.ui.components.ExampleBox
import com.example.ui.components.ExerciseInteractiveCard
import com.example.ui.components.PromptCard
import com.example.ui.components.ReadingSettingsBottomSheet
import com.example.ui.components.TipBox
import com.example.ui.components.WarningBox
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    chapter: Chapter,
    previousChapter: Chapter?,
    nextChapter: Chapter?,
    isBookmarked: Boolean,
    settings: ReaderSettings,
    exerciseAnswer: ExerciseAnswerEntity?,
    initialScrollIndex: Int = 0,
    initialScrollOffset: Int = 0,
    onBackClick: () -> Unit,
    onNavigateChapter: (Int) -> Unit,
    onToggleBookmark: (Boolean) -> Unit,
    onSaveProgress: (chapterId: Int, index: Int, offset: Int) -> Unit,
    onSaveExercise: (notes: String, isDone: Boolean) -> Unit,
    onThemeChange: (ReaderThemeMode) -> Unit,
    onFontSizeChange: (ReaderFontSize) -> Unit,
    onFontFamilyChange: (ReaderFontFamily) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val listState = rememberLazyListState(initialScrollIndex, initialScrollOffset)

    var showSettingsSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val fontFamily = when (settings.fontFamily) {
        ReaderFontFamily.SERIF -> FontFamily.Serif
        ReaderFontFamily.SANS_SERIF -> FontFamily.Default
    }
    val fontScale = settings.fontSize.scaleFactor

    // Salvar posição de leitura quando mudar de scroll ou ao sair da tela
    LaunchedEffect(listState.firstVisibleItemIndex, listState.firstVisibleItemScrollOffset) {
        onSaveProgress(chapter.id, listState.firstVisibleItemIndex, listState.firstVisibleItemScrollOffset)
    }

    val copyToClipboard: (String) -> Unit = { text ->
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Prompt IA na Prática", text)
        clipboard.setPrimaryClip(clip)
        scope.launch {
            snackbarHostState.showSnackbar("Prompt copiado para a área de transferência!")
        }
    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = chapter.numberLabel,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = chapter.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onBackClick,
                            modifier = Modifier.testTag("reader_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar"
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                onToggleBookmark(isBookmarked)
                                scope.launch {
                                    val msg = if (!isBookmarked) "Capítulo adicionado aos favoritos!" else "Removido dos favoritos"
                                    snackbarHostState.showSnackbar(msg)
                                }
                            },
                            modifier = Modifier.testTag("toggle_bookmark_button")
                        ) {
                            Icon(
                                imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "Favoritar capítulo",
                                tint = if (isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                            )
                        }

                        IconButton(
                            onClick = { showSettingsSheet = true },
                            modifier = Modifier.testTag("open_reading_settings_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.FormatSize,
                                contentDescription = "Ajustes de texto e tema"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )

                // Barra de leitura do capítulo
                val scrollFraction by remember {
                    derivedStateOf {
                        val totalItems = listState.layoutInfo.totalItemsCount
                        if (totalItems <= 1) 0f
                        else (listState.firstVisibleItemIndex.toFloat() / (totalItems - 1).toFloat()).coerceIn(0f, 1f)
                    }
                }

                LinearProgressIndicator(
                    progress = { scrollFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(horizontal = 22.dp, vertical = 20.dp)
        ) {
            // Cabeçalho do Capítulo
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = chapter.numberLabel.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "${chapter.estimatedMinutes} min de leitura",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = chapter.title,
                        style = MaterialTheme.typography.headlineLarge,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = (28 * fontScale).sp,
                        lineHeight = (36 * fontScale).sp
                    )

                    if (chapter.subtitle.isNotBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = chapter.subtitle,
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = fontFamily,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = (17 * fontScale).sp,
                            lineHeight = (25 * fontScale).sp
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }

            // Renderização das Seções do Capítulo
            itemsIndexed(chapter.sections) { _, section ->
                when (section) {
                    is ChapterSection.Paragraph -> {
                        Text(
                            text = section.text,
                            style = MaterialTheme.typography.bodyLarge,
                            fontFamily = fontFamily,
                            fontSize = (17 * fontScale).sp,
                            lineHeight = (28 * fontScale).sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    is ChapterSection.Subheading -> {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = section.title,
                            style = MaterialTheme.typography.titleLarge,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = (21 * fontScale).sp,
                            lineHeight = (28 * fontScale).sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    is ChapterSection.TipCallout -> {
                        TipBox(
                            title = section.title,
                            content = section.tip,
                            fontSizeFactor = fontScale,
                            fontFamily = fontFamily
                        )
                    }

                    is ChapterSection.WarningCallout -> {
                        WarningBox(
                            title = section.title,
                            content = section.warning,
                            fontSizeFactor = fontScale,
                            fontFamily = fontFamily
                        )
                    }

                    is ChapterSection.ExampleCallout -> {
                        ExampleBox(
                            title = section.title,
                            context = section.context,
                            before = section.beforeExample,
                            after = section.afterExample,
                            takeaway = section.takeaway,
                            fontSizeFactor = fontScale,
                            fontFamily = fontFamily
                        )
                    }

                    is ChapterSection.PromptBox -> {
                        PromptCard(
                            title = section.title,
                            promptText = section.promptText,
                            description = section.description,
                            outcome = section.expectedOutcome,
                            onCopy = copyToClipboard,
                            fontSizeFactor = fontScale,
                            fontFamily = fontFamily
                        )
                    }

                    is ChapterSection.BulletList -> {
                        Column(modifier = Modifier.padding(vertical = 8.dp)) {
                            if (!section.intro.isNullOrBlank()) {
                                Text(
                                    text = section.intro,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = (17 * fontScale).sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    modifier = Modifier.padding(bottom = 6.dp)
                                )
                            }
                            section.items.forEach { itemText ->
                                Row(
                                    modifier = Modifier.padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = "• ",
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = (18 * fontScale).sp
                                    )
                                    Text(
                                        text = itemText,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontFamily = fontFamily,
                                        fontSize = (16.5f * fontScale).sp,
                                        lineHeight = (26 * fontScale).sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }

                    is ChapterSection.StepByStep -> {
                        Column(modifier = Modifier.padding(vertical = 12.dp)) {
                            Text(
                                text = section.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                fontSize = (18 * fontScale).sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                            section.steps.forEach { step ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 6.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.surface
                                    ),
                                    border = CardDefaults.outlinedCardBorder()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(14.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(28.dp)
                                                .clip(CircleShape)
                                                .background(MaterialTheme.colorScheme.primary),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${step.stepNumber}",
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onPrimary
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column {
                                            Text(
                                                text = step.title,
                                                style = MaterialTheme.typography.titleSmall,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = (16 * fontScale).sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                text = step.description,
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontFamily = fontFamily,
                                                fontSize = (14.5f * fontScale).sp,
                                                lineHeight = (22 * fontScale).sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Resumo do Capítulo
            if (chapter.summaryPoints.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .testTag("chapter_summary_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                        )
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Resumo do Capítulo",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = (17 * fontScale).sp
                                )
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            chapter.summaryPoints.forEach { point ->
                                Row(
                                    modifier = Modifier.padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = "✓ ",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = point,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontFamily = fontFamily,
                                        fontSize = (15 * fontScale).sp,
                                        lineHeight = (23 * fontScale).sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Exercício Prático Interativo
            if (chapter.exercise != null) {
                item {
                    ExerciseInteractiveCard(
                        exercise = chapter.exercise,
                        savedNotes = exerciseAnswer?.userNotes ?: "",
                        isDone = exerciseAnswer?.isDone ?: false,
                        onSaveNotes = { notes, isDone ->
                            onSaveExercise(notes, isDone)
                            scope.launch {
                                snackbarHostState.showSnackbar("Resposta do exercício salva com sucesso!")
                            }
                        },
                        onCopyPrompt = copyToClipboard,
                        fontSizeFactor = fontScale,
                        fontFamily = fontFamily
                    )
                }
            }

            // Navegação entre capítulos
            item {
                ChapterNavigationFooter(
                    previousChapter = previousChapter,
                    nextChapter = nextChapter,
                    onNavigatePrevious = {
                        if (previousChapter != null) onNavigateChapter(previousChapter.id)
                    },
                    onNavigateNext = {
                        if (nextChapter != null) onNavigateChapter(nextChapter.id)
                    }
                )
            }
        }
    }

    if (showSettingsSheet) {
        ReadingSettingsBottomSheet(
            settings = settings,
            sheetState = sheetState,
            onDismiss = { showSettingsSheet = false },
            onThemeChange = onThemeChange,
            onFontSizeChange = onFontSizeChange,
            onFontFamilyChange = onFontFamilyChange
        )
    }
}
