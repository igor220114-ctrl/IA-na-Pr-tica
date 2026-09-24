package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        ReadingProgressEntity::class,
        BookmarkEntity::class,
        ExerciseAnswerEntity::class,
        ChecklistStateEntity::class,
        HighlightEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(IntListConverter::class)
abstract class ReaderDatabase : RoomDatabase() {

    abstract fun readerDao(): ReaderDao

    companion object {
        @Volatile
        private var INSTANCE: ReaderDatabase? = null

        fun getInstance(context: Context): ReaderDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ReaderDatabase::class.java,
                    "ianapratica_reader_database.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
