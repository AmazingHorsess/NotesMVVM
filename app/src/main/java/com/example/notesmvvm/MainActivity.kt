package com.example.notesmvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesmvvm.navigation.NotesNavHost
import com.example.notesmvvm.ui.theme.NotesMVVMTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var ar: Int = 2
            ar.toDouble()

            NotesMVVMTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(

                            title = {
                                Text(text = "NotesApp") },
                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            elevation = 12.dp



                        )
                    },
                    content = {
                        Surface(modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ){
                            NotesNavHost()

                        }
                    }
                )
            }
        }
    }
}

