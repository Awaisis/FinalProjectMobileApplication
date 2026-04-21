package com.example.taskcompanion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.taskcompanion.data.*
import com.example.taskcompanion.screens.*
import com.example.taskcompanion.viewmodel.*

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    val context = LocalContext.current
    val database = TaskDatabase.getDatabase(context)
    val repository = OfflineTaskRepository(database.taskDao())

    val viewModel: TaskViewModel = viewModel(
        factory = TaskViewModelFactory(repository)
    )

    NavHost(navController, startDestination = "home") {

        composable("home") {
            HomeScreen(navController, viewModel)
        }

        composable("add_edit/{taskId?}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            AddEditTaskScreen(navController, viewModel, taskId)
        }

        composable("details/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toInt() ?: 0
            TaskDetailsScreen(navController, viewModel, taskId)
        }
    }
}