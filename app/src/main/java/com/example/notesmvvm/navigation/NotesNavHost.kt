package com.example.notesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesmvvm.MainViewModel
import com.example.notesmvvm.screens.AddScreen
import com.example.notesmvvm.screens.MainScreen
import com.example.notesmvvm.screens.NoteScreen

import com.example.notesmvvm.screens.StartScreen
import com.example.notesmvvm.utils.Constants

sealed class NavRoute(val route: String){
    object  Start: NavRoute("start_screen")
    object  Main: NavRoute("main_screen")
    object  Add: NavRoute("add_screen")
    object  Note: NavRoute("note_screen")
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
    }
}