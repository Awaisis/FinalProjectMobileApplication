package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.taskcompanion.viewmodel.TaskViewModel

@Composable
fun TaskDetailsScreen(
    navController: NavController,
    viewModel: TaskViewModel,
    taskId: Int
) {

    val tasks = viewModel.tasks.collectAsState().value
    val task = tasks.firstOrNull { it.id == taskId }

    task?.let {

        Column {

            Text(it.title)
            Text(it.description)
            Text(it.dueDate)

            Button(onClick = {
                viewModel.toggleTaskCompletion(it)
            }) {
                Text(if (it.isCompleted) "Undo" else "Complete")
            }

            Button(onClick = {
                viewModel.deleteTask(it)
                navController.popBackStack()
            }) {
                Text("Delete")
            }

            Button(onClick = {
                navController.navigate("add_edit/${it.id}")
            }) {
                Text("Edit")
            }
        }
    }
}