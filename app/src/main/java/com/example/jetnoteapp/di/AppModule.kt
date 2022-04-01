package com.example.jetnoteapp.di

import android.content.Context
import androidx.room.Room
import com.example.jetnoteapp.data.NoteDataBase
import com.example.jetnoteapp.data.NoteDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesNotesDao(noteDataBase: NoteDataBase): NoteDataBaseDao = noteDataBase.NoteDao()

    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context) :NoteDataBase = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "notes_db",
    ).fallbackToDestructiveMigration()
        .build()
}