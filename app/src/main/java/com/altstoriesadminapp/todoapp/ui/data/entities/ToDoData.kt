package com.altstoriesadminapp.todoapp.ui.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.altstoriesadminapp.todoapp.ui.data.Priority

@Entity(tableName = "todo_table")
data class ToDoData(@PrimaryKey(autoGenerate = true) var id: Int, var title: String, var priority: Priority, var description : String)