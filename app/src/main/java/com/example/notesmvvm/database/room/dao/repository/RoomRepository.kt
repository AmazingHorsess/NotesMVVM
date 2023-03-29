package com.example.notesmvvm.database.room.dao.repository

import androidx.lifecycle.LiveData
import com.example.notesmvvm.database.DataBaseRepository
import com.example.notesmvvm.database.room.dao.NoteRoomDao
import com.example.notesmvvm.model.NoteModel

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DataBaseRepository {
    override val readAll: LiveData<List<NoteModel>>
        get() = noteRoomDao.getAllNotes()


    override suspend fun create(note: NoteModel, onSucces: () -> Unit) {
        noteRoomDao.addNote(note = note)
    }

    override suspend fun update(note: NoteModel, onSucces: () -> Unit) {
        noteRoomDao.updateNote(note = note)
    }

    override suspend fun delete(note: NoteModel, onSucces: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
    }


}