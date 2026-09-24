package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ui.BookReaderViewModel
import com.example.ui.bookmarks.BookmarksScreen
import com.example.ui.checklist.ChecklistScreen
import com.example.ui.glossary.GlossaryScreen
import com.example.ui.home.HomeScreen
import com.example.ui.prompts.PromptsScreen
import com.example.ui.reader.ReaderScreen
import com.example.ui.search.SearchScreen
import com.example.ui.toc.TocScreen

object BookDestinations {
    const val HOME = "home"
    const val READER = "reader/{chapterId}"
    const val TOC = "toc"
    const val SEARCH = "search"
    const val PROMPTS = "prompts"
    const val BOOKMARKS = "bookmarks"
    const val CHECKLIST = "checklist"
    const val GLOSSARY = "glossary"

    fun readerRoute(chapterId: Int) = "reader/$chapterId"
}

@Composable
fun BookNavGraph(
    navController: NavHostController,
    viewModel: BookReaderViewModel,
    modifier: Modifier = Modifier
) {
    val progress by viewModel.readingProgress.collectAsState()
    val bookmarks by viewModel.bookmarks.collectAsState()
    val settings by viewModel.readerSettings.collectAsState()
    val checklistStates by viewModel.checklistStates.collectAsState()

    NavHost(
        navController = navController,
        startDestination = BookDestinations.HOME,
        modifier = modifier
    ) {
        composable(BookDestinations.HOME) {
            HomeScreen(
                book = viewModel.book,
                progress = progress,
                bookmarks = bookmarks,
                onStartReading = { chapterId ->
                    navController.navigate(BookDestinations.readerRoute(chapterId))
                },
                onOpenToc = { navController.navigate(BookDestinations.TOC) },
                onOpenSearch = { navController.navigate(BookDestinations.SEARCH) },
                onOpenPrompts = { navController.navigate(BookDestinations.PROMPTS) },
                onOpenBookmarks = { navController.navigate(BookDestinations.BOOKMARKS) },
                onOpenChecklist = { navController.navigate(BookDestinations.CHECKLIST) },
                onOpenGlossary = { navController.navigate(BookDestinations.GLOSSARY) }
            )
        }

        composable(
            route = BookDestinations.READER,
            arguments = listOf(navArgument("chapterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val chapterId = backStackEntry.arguments?.getInt("chapterId") ?: 0
            val chapter = viewModel.getChapter(chapterId) ?: viewModel.book.chapters.first()
            val (prevChapter, nextChapter) = viewModel.getAdjacentChapters(chapterId)
            val isBookmarked by viewModel.isChapterBookmarked(chapterId).collectAsState(initial = false)
            val exerciseAnswer by (chapter.exercise?.let { viewModel.getExerciseAnswer(it.id) }
                ?.collectAsState(initial = null) ?: androidx.compose.runtime.remember {
                androidx.compose.runtime.mutableStateOf(null)
            })

            // Restaura o índice de scroll se for o capítulo salvo anteriormente
            val initialIndex = if (progress?.currentChapterId == chapterId) progress?.scrollIndex ?: 0 else 0
            val initialOffset = if (progress?.currentChapterId == chapterId) progress?.scrollOffset ?: 0 else 0

            ReaderScreen(
                chapter = chapter,
                previousChapter = prevChapter,
                nextChapter = nextChapter,
                isBookmarked = isBookmarked,
                settings = settings,
                exerciseAnswer = exerciseAnswer,
                initialScrollIndex = initialIndex,
                initialScrollOffset = initialOffset,
                onBackClick = { navController.popBackStack() },
                onNavigateChapter = { targetId ->
                    navController.navigate(BookDestinations.readerRoute(targetId)) {
                        popUpTo(BookDestinations.HOME)
                    }
                },
                onToggleBookmark = { currentlyBookmarked ->
                    viewModel.toggleBookmark(
                        chapterId = chapter.id,
                        previewText = chapter.subtitle,
                        isCurrentlyBookmarked = currentlyBookmarked
                    )
                },
                onSaveProgress = { cId, index, offset ->
                    viewModel.saveProgress(cId, index, offset)
                },
                onSaveExercise = { notes, isDone ->
                    chapter.exercise?.let { ex ->
                        viewModel.saveExerciseAnswer(ex.id, chapter.id, notes, isDone)
                    }
                },
                onThemeChange = { viewModel.updateThemeMode(it) },
                onFontSizeChange = { viewModel.updateFontSize(it) },
                onFontFamilyChange = { viewModel.updateFontFamily(it) }
            )
        }

        composable(BookDestinations.TOC) {
            TocScreen(
                book = viewModel.book,
                currentChapterId = progress?.currentChapterId ?: 0,
                completedChapterIds = progress?.completedChapterIds ?: emptyList(),
                onChapterSelect = { chapterId ->
                    navController.navigate(BookDestinations.readerRoute(chapterId)) {
                        popUpTo(BookDestinations.HOME)
                    }
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(BookDestinations.SEARCH) {
            SearchScreen(
                onSearch = { query -> viewModel.searchBook(query) },
                onSelectChapter = { chapterId ->
                    navController.navigate(BookDestinations.readerRoute(chapterId))
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(BookDestinations.PROMPTS) {
            PromptsScreen(
                prompts = viewModel.book.promptVault,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(BookDestinations.BOOKMARKS) {
            BookmarksScreen(
                bookmarks = bookmarks,
                onSelectChapter = { chapterId ->
                    navController.navigate(BookDestinations.readerRoute(chapterId))
                },
                onDeleteBookmark = { id -> viewModel.deleteBookmark(id) },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(BookDestinations.CHECKLIST) {
            ChecklistScreen(
                items = viewModel.book.checklist,
                states = checklistStates,
                onToggleCheck = { itemId, isChecked ->
                    viewModel.toggleChecklist(itemId, isChecked)
                },
                onResetAll = { viewModel.resetChecklist() },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(BookDestinations.GLOSSARY) {
            GlossaryScreen(
                glossary = viewModel.book.glossary,
                aboutAuthor = viewModel.book.aboutAuthor,
                disclaimer = viewModel.book.disclaimer,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
