package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskcompanion.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailsScreen(
    navController: NavController,
    viewModel: TaskViewModel,
    taskIndex: Int
) {
    val task = viewModel.tasks[taskIndex]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Task Details") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // 🔹 Title
            Text(
                text = task.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            // 🔹 Description
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            // 🔹 Due Date
            Text(
                text = "Due Date: ${task.dueDate}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Mark Complete Button
            Button(
                onClick = {
                    viewModel.toggleTaskCompletion(task)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (task.isCompleted) "Mark as Incomplete"
                    else "Mark Complete"
                )
            }

            // Edit Button
            Button(
                onClick = {
                    navController.navigate("add_edit/$taskIndex")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Edit Task")
            }

            // Delete Button
            Button(
                onClick = {
                    viewModel.deleteTask(task)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Delete Task")
            }

            // Back Button
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back")
            }
        }
    }
}