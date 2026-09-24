package com.example.data.repository

import com.example.data.local.BookmarkEntity
import com.example.data.local.ChecklistStateEntity
import com.example.data.local.ExerciseAnswerEntity
import com.example.data.local.HighlightEntity
import com.example.data.local.ReaderDao
import com.example.data.local.ReadingProgressEntity
import com.example.data.preferences.ReaderFontSize
import com.example.data.preferences.ReaderPreferences
import com.example.data.preferences.ReaderSettings
import com.example.data.preferences.ReaderThemeMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class UserDataRepository(
    private val dao: ReaderDao,
    private val preferences: ReaderPreferences
) {
    val readerSettings: StateFlow<ReaderSettings> = preferences.settings

    fun setThemeMode(mode: ReaderThemeMode) = preferences.setThemeMode(mode)
    fun setFontSize(size: ReaderFontSize) = preferences.setFontSize(size)
    fun setFontFamily(family: com.example.data.preferences.ReaderFontFamily) = preferences.setFontFamily(family)

    fun getReadingProgress(bookId: String): Flow<ReadingProgressEntity?> =
        dao.getProgress(bookId)

    suspend fun saveReadingProgress(progress: ReadingProgressEntity) =
        dao.saveProgress(progress)

    fun getAllBookmarks(): Flow<List<BookmarkEntity>> =
        dao.getAllBookmarks()

    fun isChapterBookmarked(chapterId: Int): Flow<Boolean> =
        dao.isChapterBookmarked(chapterId)

    suspend fun toggleBookmark(
        chapterId: Int,
        chapterTitle: String,
        chapterNumber: String,
        previewText: String,
        isCurrentlyBookmarked: Boolean
    ) {
        if (isCurrentlyBookmarked) {
            dao.deleteBookmarkByChapter(chapterId)
        } else {
            dao.insertBookmark(
                BookmarkEntity(
                    chapterId = chapterId,
                    chapterTitle = chapterTitle,
                    chapterNumber = chapterNumber,
                    previewText = previewText
                )
            )
        }
    }

    suspend fun deleteBookmark(id: Long) = dao.deleteBookmarkById(id)

    fun getExerciseAnswer(exerciseId: String): Flow<ExerciseAnswerEntity?> =
        dao.getExerciseAnswer(exerciseId)

    suspend fun saveExerciseAnswer(exerciseId: String, chapterId: Int, notes: String, isDone: Boolean) {
        dao.saveExerciseAnswer(
            ExerciseAnswerEntity(
                exerciseId = exerciseId,
                chapterId = chapterId,
                userNotes = notes,
                isDone = isDone,
                updatedTimestamp = System.currentTimeMillis()
            )
        )
    }

    fun getAllChecklistStates(): Flow<List<ChecklistStateEntity>> =
        dao.getAllChecklistStates()

    suspend fun setChecklistState(itemId: String, isChecked: Boolean) {
        dao.saveChecklistState(ChecklistStateEntity(itemId = itemId, isChecked = isChecked))
    }

    fun getAllHighlights(): Flow<List<HighlightEntity>> =
        dao.getAllHighlights()

    suspend fun addHighlight(chapterId: Int, chapterTitle: String, text: String, note: String = "") {
        dao.insertHighlight(
            HighlightEntity(
                chapterId = chapterId,
                chapterTitle = chapterTitle,
                text = text,
                note = note
            )
        )
    }

    suspend fun deleteHighlight(id: Long) = dao.deleteHighlightById(id)
}
