package com.example.notesmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesmvvm.database.room.dao.repository.AppRoomDatabase
import com.example.notesmvvm.database.room.dao.repository.RoomRepository
import com.example.notesmvvm.model.NoteModel
import com.example.notesmvvm.utils.REPOSITORY
import com.example.notesmvvm.utils.TYPE_FIREBASE
import com.example.notesmvvm.utils.TYPE_ROOM

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

}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }

}