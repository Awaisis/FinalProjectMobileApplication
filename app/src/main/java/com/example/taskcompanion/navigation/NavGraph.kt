package com.example.taskcompanion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskcompanion.screens.HomeScreen
import com.example.taskcompanion.screens.AddEditTaskScreen
import com.example.taskcompanion.screens.TaskDetailsScreen
@Composable
fun NavGraph() {

    val navController = rememberNavController()

    val viewModel: com.example.taskcompanion.viewmodel.TaskViewModel =
        androidx.lifecycle.viewmodel.compose.viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController, viewModel)
        }

        composable("add_edit") {
            AddEditTaskScreen(navController, viewModel)
        }

        composable("details/{index}") { backStackEntry ->

            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0

            TaskDetailsScreen(
                navController = navController,
                viewModel = viewModel,
                taskIndex = index
            )
        }

        composable("add_edit/{index}") { backStackEntry ->

            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull()

            AddEditTaskScreen(navController, viewModel, index)
        }
    }
}