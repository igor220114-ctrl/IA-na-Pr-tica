package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "reading_progress")
data class ReadingProgressEntity(
    @PrimaryKey val bookId: String,
    val currentChapterId: Int,
    val scrollIndex: Int = 0,
    val scrollOffset: Int = 0,
    val completedChapterIds: List<Int> = emptyList(),
    val lastReadTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chapterId: Int,
    val chapterTitle: String,
    val chapterNumber: String,
    val previewText: String,
    val createdTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "exercise_answers")
data class ExerciseAnswerEntity(
    @PrimaryKey val exerciseId: String,
    val chapterId: Int,
    val userNotes: String,
    val isDone: Boolean = false,
    val updatedTimestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "checklist_states")
data class ChecklistStateEntity(
    @PrimaryKey val itemId: String,
    val isChecked: Boolean = false
)

@Entity(tableName = "highlights")
data class HighlightEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chapterId: Int,
    val chapterTitle: String,
    val text: String,
    val note: String = "",
    val colorHex: String = "#FFE082", // warm amber highlight
    val createdTimestamp: Long = System.currentTimeMillis()
)

class IntListConverter {
    @TypeConverter
    fun fromList(list: List<Int>?): String {
        return list?.joinToString(separator = ",") ?: ""
    }

    @TypeConverter
    fun toList(data: String?): List<Int> {
        if (data.isNullOrBlank()) return emptyList()
        return data.split(",").mapNotNull { it.trim().toIntOrNull() }
    }
}
