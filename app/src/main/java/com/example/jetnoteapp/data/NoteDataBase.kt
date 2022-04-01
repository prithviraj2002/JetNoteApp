package com.example.jetnoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnoteapp.model.Note
import com.example.jetnoteapp.ui.theme.utill.DateConverter
import com.example.jetnoteapp.ui.theme.utill.UUIDConverter

@Database(entities = [Note::class], exportSchema = false, version = 1)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun NoteDao(): NoteDataBaseDao
}