package com.example.room.addtasks.ui.TaskModel

data class TaskModel (
    val id: Long = System.currentTimeMillis(),
    val task: String,
    var selected: Boolean = false
)