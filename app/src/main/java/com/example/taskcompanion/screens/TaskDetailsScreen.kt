package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskcompanion.viewmodel.TaskViewModel

@Composable
fun TaskDetailsScreen(
    navController: NavController,
    viewModel: TaskViewModel,
    taskId: Int
) {

    val task = viewModel.getTaskById(taskId)

    task?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(it.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))

            Text(it.description)
            Spacer(modifier = Modifier.height(8.dp))

            Text("Due: ${it.dueDate}")
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.toggleTaskCompletion(it)
            }) {
                Text(
                    if (it.isCompleted) "Mark Incomplete"
                    else "Mark Complete"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                viewModel.deleteTask(it)
                navController.popBackStack()
            }) {
                Text("Delete Task")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                navController.navigate("add_edit/${it.id}")
            }) {
                Text("Edit Task")
            }
        }
    }
}