package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.book.BookRepository
import com.example.data.book.DefaultBookRepository
import com.example.data.book.SearchResult
import com.example.data.local.BookmarkEntity
import com.example.data.local.ChecklistStateEntity
import com.example.data.local.ExerciseAnswerEntity
import com.example.data.local.ReadingProgressEntity
import com.example.data.model.Book
import com.example.data.model.Chapter
import com.example.data.preferences.ReaderFontFamily
import com.example.data.preferences.ReaderFontSize
import com.example.data.preferences.ReaderSettings
import com.example.data.preferences.ReaderThemeMode
import com.example.data.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BookReaderViewModel(
    private val bookRepository: BookRepository,
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    val book: Book = bookRepository.getBook()

    val readingProgress: StateFlow<ReadingProgressEntity?> =
        userDataRepository.getReadingProgress(book.id)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = null
            )

    val bookmarks: StateFlow<List<BookmarkEntity>> =
        userDataRepository.getAllBookmarks()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    val readerSettings: StateFlow<ReaderSettings> =
        userDataRepository.readerSettings

    val checklistStates: StateFlow<List<ChecklistStateEntity>> =
        userDataRepository.getAllChecklistStates()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun getChapter(chapterId: Int): Chapter? =
        bookRepository.getChapter(chapterId)

    fun getAdjacentChapters(currentChapterId: Int): Pair<Chapter?, Chapter?> {
        val prev = bookRepository.getPreviousChapter(currentChapterId)
        val next = bookRepository.getNextChapter(currentChapterId)
        return Pair(prev, next)
    }

    fun isChapterBookmarked(chapterId: Int): Flow<Boolean> =
        userDataRepository.isChapterBookmarked(chapterId)

    fun getExerciseAnswer(exerciseId: String): Flow<ExerciseAnswerEntity?> =
        userDataRepository.getExerciseAnswer(exerciseId)

    fun saveProgress(chapterId: Int, scrollIndex: Int, scrollOffset: Int) {
        viewModelScope.launch {
            val currentProgress = readingProgress.value
            val completed = currentProgress?.completedChapterIds?.toMutableSet() ?: mutableSetOf()
            completed.add(chapterId)

            userDataRepository.saveReadingProgress(
                ReadingProgressEntity(
                    bookId = book.id,
                    currentChapterId = chapterId,
                    scrollIndex = scrollIndex,
                    scrollOffset = scrollOffset,
                    completedChapterIds = completed.toList(),
                    lastReadTimestamp = System.currentTimeMillis()
                )
            )
        }
    }

    fun toggleBookmark(chapterId: Int, previewText: String, isCurrentlyBookmarked: Boolean) {
        viewModelScope.launch {
            val chapter = bookRepository.getChapter(chapterId) ?: return@launch
            userDataRepository.toggleBookmark(
                chapterId = chapterId,
                chapterTitle = chapter.title,
                chapterNumber = chapter.numberLabel,
                previewText = previewText,
                isCurrentlyBookmarked = isCurrentlyBookmarked
            )
        }
    }

    fun deleteBookmark(id: Long) {
        viewModelScope.launch {
            userDataRepository.deleteBookmark(id)
        }
    }

    fun saveExerciseAnswer(exerciseId: String, chapterId: Int, notes: String, isDone: Boolean) {
        viewModelScope.launch {
            userDataRepository.saveExerciseAnswer(exerciseId, chapterId, notes, isDone)
        }
    }

    fun toggleChecklist(itemId: String, isChecked: Boolean) {
        viewModelScope.launch {
            userDataRepository.setChecklistState(itemId, isChecked)
        }
    }

    fun resetChecklist() {
        viewModelScope.launch {
            book.checklist.forEach {
                userDataRepository.setChecklistState(it.id, false)
            }
        }
    }

    fun updateThemeMode(mode: ReaderThemeMode) = userDataRepository.setThemeMode(mode)
    fun updateFontSize(size: ReaderFontSize) = userDataRepository.setFontSize(size)
    fun updateFontFamily(family: ReaderFontFamily) = userDataRepository.setFontFamily(family)

    fun searchBook(query: String): List<SearchResult> =
        bookRepository.searchContent(query)

    class Factory(
        private val bookRepository: BookRepository,
        private val userDataRepository: UserDataRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BookReaderViewModel(bookRepository, userDataRepository) as T
        }
    }
}
