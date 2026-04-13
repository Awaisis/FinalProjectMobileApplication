package com.example.taskcompanion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskcompanion.screens.HomeScreen
import com.example.taskcompanion.screens.AddEditTaskScreen
import com.example.taskcompanion.screens.HomeScreen
import com.example.taskcompanion.screens.TaskDetailsScreen

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

        composable("add_edit") {
            AddEditTaskScreen(navController)
        }

        composable("details") {
            TaskDetailsScreen(navController)
        }
    }
}