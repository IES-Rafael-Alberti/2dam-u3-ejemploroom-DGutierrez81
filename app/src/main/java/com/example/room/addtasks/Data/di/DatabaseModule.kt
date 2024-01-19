package com.example.room.addtasks.Data.di

import android.content.Context
import androidx.room.Room
import com.example.room.addtasks.Data.TaskDao
import com.example.room.addtasks.Data.TasksManageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Debe ser un Singleton para que la base de datos se única en nuestro proyecto.
//Utilizaremos la notación de Hilt con @Provides.


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    //Aquí va a recibir la base de datos mediante la inyección de Dagge Hilt...
    //Es una caja negra para nosostrosm las maravillas de la inyección de dependencias...
    //una especie de "mágia" que va a realizar Dagger Hilt por nosotros gracias a las anotaciones.
    //va a proveer las clases que necesite...
    @Provides
    fun provideTaskDao(tasksManageDatabase: TasksManageDatabase): TaskDao {
        //Por eso en TasksMangeDatabase estaba esta función abstract fun taskDao(): TaskDao
        //para que esto aytomáticamente me devuelva el DAO (obejto de tipo TaskDao)
        return tasksManageDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTasksManageDatabase(@ApplicationContext appContext: Context): TasksManageDatabase {
        //Aquí ralmente es dónde estamos CREANDO la base de datos...
        return Room.databaseBuilder(appContext, TasksManageDatabase::class.java, "TaskDatabase").build()    }
}