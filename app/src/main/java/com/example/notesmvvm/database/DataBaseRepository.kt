package com.example.notesmvvm.database

import androidx.lifecycle.LiveData
import com.example.notesmvvm.model.NoteModel

interface DataBaseRepository {
    val readAll: LiveData<List<NoteModel>>

    suspend fun create(note: NoteModel, onSucces: () -> Unit)

    suspend fun update(note: NoteModel, onSucces: () -> Unit)

    suspend fun delete(note: NoteModel, onSucces: () -> Unit)
}