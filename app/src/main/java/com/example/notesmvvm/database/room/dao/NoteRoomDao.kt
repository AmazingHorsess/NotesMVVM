package com.example.notesmvvm.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notesmvvm.model.NoteModel

@Dao
interface NoteRoomDao {


    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Insert
    suspend fun addNote(note: NoteModel)

    @Update
    suspend fun updateNote(note: NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)
}