package com.example.taskcompanion.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.taskcompanion.viewmodel.TaskViewModel
import com.example.taskcompanion.screens.*

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val viewModel: TaskViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController, viewModel)
        }

        composable("add_edit/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments
                ?.getString("taskId")
                ?.toIntOrNull()

            AddEditTaskScreen(navController, viewModel, taskId)
        }

        composable("details/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments
                ?.getString("taskId")
                ?.toIntOrNull() ?: 0

            TaskDetailsScreen(navController, viewModel, taskId)
        }
    }
}