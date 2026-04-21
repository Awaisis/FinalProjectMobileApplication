package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskcompanion.data.Task
import com.example.taskcompanion.viewmodel.TaskViewModel
import androidx.compose.foundation.lazy.itemsIndexed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TaskCompanion") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_edit") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Text("+")
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            itemsIndexed(viewModel.tasks) { index, task ->
                TaskCard(task, navController, viewModel, index)
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    navController: NavController,
    viewModel: TaskViewModel,
    index: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = {
            navController.navigate("details/$index")
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = if (task.isCompleted)
                        MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Due: ${task.dueDate}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Column {

                Checkbox(
                    checked = task.isCompleted,
                    onCheckedChange = {
                        viewModel.toggleTaskCompletion(task)
                    }
                )

                IconButton(onClick = {
                    viewModel.deleteTask(task)
                }) {
                    Text("Delete")
                }
            }
        }
    }
}
