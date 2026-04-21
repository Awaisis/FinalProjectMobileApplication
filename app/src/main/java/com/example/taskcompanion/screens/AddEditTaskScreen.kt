package com.example.taskcompanion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskcompanion.data.Task
import com.example.taskcompanion.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: TaskViewModel,
    taskId: Int?
) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }

    val isEdit = taskId != null && taskId != 0

    if (isEdit) {
        val task = viewModel.getTaskById(taskId!!)

        LaunchedEffect(task) {
            task?.let {
                title = it.title
                description = it.description
                dueDate = it.dueDate
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(if (isEdit) "Edit Task" else "Add Task")
                }
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

            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = dueDate,
                onValueChange = { dueDate = it },
                label = { Text("Due Date") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                    if (isEdit) {
                        viewModel.addTask(
                            Task(
                                id = taskId!!,
                                title = title,
                                description = description,
                                dueDate = dueDate
                            )
                        )
                    } else {
                        viewModel.addTask(
                            Task(
                                id = 0,
                                title = title,
                                description = description,
                                dueDate = dueDate
                            )
                        )
                    }

                    navController.popBackStack()
                }
            ) {
                Text("Save")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.popBackStack() }
            ) {
                Text("Cancel")
            }
        }
    }
}