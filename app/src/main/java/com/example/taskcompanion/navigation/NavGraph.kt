package com.example.taskcompanion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.taskcompanion.ui.screens.*

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("addEdit") {
            AddEditTaskScreen(navController)
        }

        composable("details") {
            TaskDetailsScreen(navController)
        }
    }
}