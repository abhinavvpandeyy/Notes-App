package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):  AndroidViewModel(application) {

    private val repository :NoteRepository
    val allNote: LiveData<List<Note>>

    init {
        val dao= NoteDatabase.getDatabase(application).getNoteDAO()
        repository= NoteRepository(dao)

        allNote=repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)

    }
    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)


    }
}