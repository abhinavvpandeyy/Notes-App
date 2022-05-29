package com.example.notesapp

import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.LiveData

class NoteRepository(private val noteDAO: NoteDAO) {

    val allNotes:LiveData<List<Note>> = noteDAO.getAllNotes()

    suspend fun insert(note: Note) {
        noteDAO.insert(note)
    }

    suspend fun delete(note: Note) {
        noteDAO.delete(note)
    }
}