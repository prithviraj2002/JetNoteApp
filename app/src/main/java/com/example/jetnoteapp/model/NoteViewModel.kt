package com.example.jetnoteapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnoteapp.Repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository): ViewModel () {

    private val _notesList = MutableStateFlow<List<Note>>(emptyList())
    var notesList = _notesList.asStateFlow()

    init{
      viewModelScope.launch(Dispatchers.IO) {
          noteRepository.getAllNotes().distinctUntilChanged().collect { listOfNotes->
              if(listOfNotes.isNullOrEmpty()){

              }
              else{
                  _notesList.value = listOfNotes
              }
          }
      }
    }

    fun addNote(note: Note) = viewModelScope.launch { noteRepository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { noteRepository.updateNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch { noteRepository.deleteNote(note) }
    //suspend fun deleteAllNotes() = viewModelScope.launch { noteRepository.deleteAllNotes() }

}