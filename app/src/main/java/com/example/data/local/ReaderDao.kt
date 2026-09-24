package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReaderDao {

    // Reading Progress
    @Query("SELECT * FROM reading_progress WHERE bookId = :bookId LIMIT 1")
    fun getProgress(bookId: String): Flow<ReadingProgressEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: ReadingProgressEntity)

    // Bookmarks
    @Query("SELECT * FROM bookmarks ORDER BY createdTimestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT COUNT(*) > 0 FROM bookmarks WHERE chapterId = :chapterId")
    fun isChapterBookmarked(chapterId: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE chapterId = :chapterId")
    suspend fun deleteBookmarkByChapter(chapterId: Int)

    @Query("DELETE FROM bookmarks WHERE id = :id")
    suspend fun deleteBookmarkById(id: Long)

    // Exercise Answers
    @Query("SELECT * FROM exercise_answers WHERE exerciseId = :exerciseId LIMIT 1")
    fun getExerciseAnswer(exerciseId: String): Flow<ExerciseAnswerEntity?>

    @Query("SELECT * FROM exercise_answers")
    fun getAllExerciseAnswers(): Flow<List<ExerciseAnswerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveExerciseAnswer(entity: ExerciseAnswerEntity)

    // Checklist states
    @Query("SELECT * FROM checklist_states")
    fun getAllChecklistStates(): Flow<List<ChecklistStateEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveChecklistState(state: ChecklistStateEntity)

    // Highlights
    @Query("SELECT * FROM highlights ORDER BY createdTimestamp DESC")
    fun getAllHighlights(): Flow<List<HighlightEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHighlight(highlight: HighlightEntity)

    @Query("DELETE FROM highlights WHERE id = :id")
    suspend fun deleteHighlightById(id: Long)
}
