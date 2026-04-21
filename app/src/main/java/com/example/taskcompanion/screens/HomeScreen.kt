package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskcompanion.data.Task
import com.example.taskcompanion.viewmodel.TaskViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: TaskViewModel) {

    val tasks = viewModel.tasks.collectAsState().value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_edit/0") }
            ) { Text("+") }
        }
    ) { padding ->

        LazyColumn(modifier = Modifier.padding(padding)) {
            items(tasks) { task ->
                TaskCard(task, navController, viewModel)
            }
        }
    }
}

@Composable
fun TaskCard(task: Task, navController: NavController, viewModel: TaskViewModel) {

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        onClick = {
            navController.navigate("details/${task.id}")
        }
    ) {

        Column(Modifier.padding(16.dp)) {
            Text(task.title)
            Text(task.description)

            Row {

                Checkbox(
                    checked = task.isCompleted,
                    onCheckedChange = { viewModel.toggleTaskCompletion(task) }
                )

                Button(onClick = { viewModel.deleteTask(task) }) {
                    Text("Delete")
                }
            }
        }
    }
}