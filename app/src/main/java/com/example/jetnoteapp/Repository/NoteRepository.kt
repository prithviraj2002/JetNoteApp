package com.example.jetnoteapp.Repository

import com.example.jetnoteapp.data.NoteDataBase
import com.example.jetnoteapp.data.NoteDataBaseDao
import com.example.jetnoteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDataBaseDao: NoteDataBaseDao) {

    suspend fun addNote(note: Note) = noteDataBaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDataBaseDao.update(note)
    suspend fun deleteNote(note: Note) = noteDataBaseDao.delNote(note)
    suspend fun deleteAllNotes() = noteDataBaseDao.deleteAll()
    fun getAllNotes(): Flow<List<Note>> = noteDataBaseDao.getAllNotes().flowOn(Dispatchers.IO)
        .conflate()
}