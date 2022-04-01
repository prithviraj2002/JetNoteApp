package com.example.jetnoteapp.data

import androidx.room.*
import com.example.jetnoteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataBaseDao {

    @Query("SELECT *from notes_table")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT *from notes_table where id =:id")
    suspend fun findNote(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delNote(note: Note)

}
