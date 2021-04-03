package com.altstoriesadminapp.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.altstoriesadminapp.todoapp.data.dao.ToDoDao
import com.altstoriesadminapp.todoapp.data.entities.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }
}