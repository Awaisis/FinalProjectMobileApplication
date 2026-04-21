package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskcompanion.data.Task
import com.example.taskcompanion.viewmodel.TaskViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {

    val tasks by viewModel.tasks.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_edit/0") }
            ) {
                Text("+")
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            items(tasks) { task ->
                TaskCard(task, navController, viewModel)
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    navController: NavController,
    viewModel: TaskViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            navController.navigate("details/${task.id}")
        }
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Text(text = task.description)

            Row {

                Checkbox(
                    checked = task.isCompleted,
                    onCheckedChange = {
                        viewModel.toggleTaskCompletion(task)
                    }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {
                    viewModel.deleteTask(task)
                }) {
                    Text("Delete")
                }
            }
        }
    }
}