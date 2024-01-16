package com.example.room.addtasks.ui.model

data class TaskModel (
    //El método hashcode() nos crea un código único a través del número
    //El hascode() es lo que utiliza el compilador para comparar objeto
    //lo hace a través del hascode() que se genera en cada objeto.

    val id: Int = System.currentTimeMillis().hashCode(),
    val task: String,
    var selected: Boolean = false
)