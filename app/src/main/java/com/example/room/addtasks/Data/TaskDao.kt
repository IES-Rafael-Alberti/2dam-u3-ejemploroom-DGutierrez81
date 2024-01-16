package com.example.room.addtasks.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Define una interfaz que contiene métodos para interactuar con la tabla TasjTEbtity en la base de datos.
 */
@Dao
interface TaskDao {
    //Básicamente nos vamos a enganchar a través de Flowm va a retornar un Flow con una lista de TaskEntity,
    //y las librerías de Flow se encargarán de avisar cuando algún dato de la Entidad se hata agregadom actualizado o eliminado.
    @Query("SELECT * from TaskEntity")
    fun getTasks(): Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(item:TaskEntity)



}