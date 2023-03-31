package com.example.notesmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.notesmvvm.database.room.dao.repository.AppRoomDatabase
import com.example.notesmvvm.database.room.dao.repository.RoomRepository
import com.example.notesmvvm.model.NoteModel
import com.example.notesmvvm.utils.REPOSITORY
import com.example.notesmvvm.utils.TYPE_FIREBASE
import com.example.notesmvvm.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {


    val context = application
    fun initDatabase(type: String, onSucess:()->Unit) {
        Log.d("checkdata", "MainViewModel initDatabase with type: $type")
        when(type){
            TYPE_ROOM ->{
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSucess()

            }
        }
    }
    fun addNote(note: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }
    fun readAllNotes() = REPOSITORY.readAll


    fun updateNote(note: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.update(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun deleteNote(note: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }

}