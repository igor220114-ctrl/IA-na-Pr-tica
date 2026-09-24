package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.ChapterExercise
import com.example.ui.theme.ExampleContainer
import com.example.ui.theme.ExampleContainerDark
import com.example.ui.theme.ExampleContent
import com.example.ui.theme.ExampleContentDark
import com.example.ui.theme.TipContainer
import com.example.ui.theme.TipContainerDark
import com.example.ui.theme.TipContent
import com.example.ui.theme.TipContentDark
import com.example.ui.theme.WarningContainer
import com.example.ui.theme.WarningContainerDark
import com.example.ui.theme.WarningContent
import com.example.ui.theme.WarningContentDark

@Composable
fun TipBox(
    title: String,
    content: String,
    fontSizeFactor: Float = 1.0f,
    fontFamily: FontFamily = FontFamily.Default,
    modifier: Modifier = Modifier
) {
    val isDark = isSystemInDarkTheme()
    val bgColor = if (isDark) TipContainerDark else TipContainer
    val iconColor = if (isDark) TipContentDark else TipContent

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .testTag("tip_box"),
        shape = RoundedCornerShape(14.dp),
        color = bgColor,
        tonalElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = "Dica prática",
                tint = iconColor,
                modifier = Modifier
                    .size(24.dp)
                    .padding(top = 2.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = iconColor,
                    fontSize = (16 * fontSizeFactor).sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = fontFamily,
                    lineHeight = (22 * fontSizeFactor).sp,
                    fontSize = (15 * fontSizeFactor).sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun WarningBox(
    title: String,
    content: String,
    fontSizeFactor: Float = 1.0f,
    fontFamily: FontFamily = FontFamily.Default,
    modifier: Modifier = Modifier
) {
    val isDark = isSystemInDarkTheme()
    val bgColor = if (isDark) WarningContainerDark else WarningContainer
    val iconColor = if (isDark) WarningContentDark else WarningContent

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .testTag("warning_box"),
        shape = RoundedCornerShape(14.dp),
        color = bgColor,
        tonalElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Alerta",
                tint = iconColor,
                modifier = Modifier
                    .size(24.dp)
                    .padding(top = 2.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = iconColor,
                    fontSize = (16 * fontSizeFactor).sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = fontFamily,
                    lineHeight = (22 * fontSizeFactor).sp,
                    fontSize = (15 * fontSizeFactor).sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun ExampleBox(
    title: String,
    context: String,
    before: String?,
    after: String,
    takeaway: String,
    fontSizeFactor: Float = 1.0f,
    fontFamily: FontFamily = FontFamily.Default,
    modifier: Modifier = Modifier
) {
    val isDark = isSystemInDarkTheme()
    val containerBg = if (isDark) ExampleContainerDark else ExampleContainer
    val accentColor = if (isDark) ExampleContentDark else ExampleContent

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .testTag("example_box"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = containerBg)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Psychology,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = accentColor,
                    fontSize = (16 * fontSizeFactor).sp
                )
            }

            if (context.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = context,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = (13 * fontSizeFactor).sp
                )
            }

            if (!before.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
                        .padding(12.dp)
                ) {
                    Column {
                        Text(
                            text = "❌ Jeito Fraco / Ineficaz:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = before,
                            style = MaterialTheme.typography.bodyMedium,
                            fontFamily = fontFamily,
                            fontSize = (14 * fontSizeFactor).sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, accentColor.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Column {
                    Text(
                        text = "✅ Jeito Eficaz / Recomendado:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = accentColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = after,
                        style = MaterialTheme.typography.bodyMedium,
                        fontFamily = fontFamily,
                        fontSize = (14 * fontSizeFactor).sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            if (takeaway.isNotBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "💡 Lição: $takeaway",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = (13 * fontSizeFactor).sp
                )
            }
        }
    }
}

@Composable
fun PromptCard(
    title: String,
    promptText: String,
    description: String,
    outcome: String,
    onCopy: (String) -> Unit,
    fontSizeFactor: Float = 1.0f,
    fontFamily: FontFamily = FontFamily.Default,
    modifier: Modifier = Modifier
) {
    var copied by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .testTag("prompt_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        ),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📋 $title",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = (16 * fontSizeFactor).sp,
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = {
                        onCopy(promptText)
                        copied = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (copied) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
                    ),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = ButtonDefaults.TextButtonContentPadding,
                    modifier = Modifier.testTag("copy_prompt_button")
                ) {
                    Icon(
                        imageVector = if (copied) Icons.Default.Check else Icons.Default.ContentCopy,
                        contentDescription = "Copiar prompt",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (copied) "Copiado!" else "Copiar",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            if (description.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = (13 * fontSizeFactor).sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(14.dp)
            ) {
                Text(
                    text = promptText,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Monospace,
                    fontSize = (13.5f * fontSizeFactor).sp,
                    lineHeight = (20 * fontSizeFactor).sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            if (outcome.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "🎯 Resultado esperado: $outcome",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium,
                    fontSize = (12 * fontSizeFactor).sp
                )
            }
        }
    }
}

@Composable
fun ExerciseInteractiveCard(
    exercise: ChapterExercise,
    savedNotes: String,
    isDone: Boolean,
    onSaveNotes: (String, Boolean) -> Unit,
    onCopyPrompt: (String) -> Unit,
    fontSizeFactor: Float = 1.0f,
    fontFamily: FontFamily = FontFamily.Default,
    modifier: Modifier = Modifier
) {
    var notesText by remember(savedNotes) { mutableStateOf(savedNotes) }
    var doneState by remember(isDone) { mutableStateOf(isDone) }
    var saveSuccess by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .testTag("exercise_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
        ),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Exercício Prático Interativo",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = doneState,
                        onCheckedChange = {
                            doneState = it
                            onSaveNotes(notesText, doneState)
                        },
                        modifier = Modifier.testTag("exercise_checkbox")
                    )
                    Text(
                        text = if (doneState) "Concluído" else "Fazer",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = exercise.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = (17 * fontSizeFactor).sp
            )

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = exercise.instructions,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = fontFamily,
                lineHeight = (22 * fontSizeFactor).sp,
                fontSize = (15 * fontSizeFactor).sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (!exercise.suggestedPrompt.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedButton(
                    onClick = { onCopyPrompt(exercise.suggestedPrompt) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Copiar Prompt do Exercício")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Suas anotações / Resposta do exercício:",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = notesText,
                onValueChange = {
                    notesText = it
                    saveSuccess = false
                },
                placeholder = { Text("Digite sua reflexão, notas ou resultados do teste aqui...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("exercise_notes_field"),
                minLines = 3,
                maxLines = 6,
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    onSaveNotes(notesText, doneState)
                    saveSuccess = true
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .testTag("save_exercise_button"),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = if (saveSuccess) "Anotação Salva!" else "Salvar Resposta")
            }
        }
    }
}
