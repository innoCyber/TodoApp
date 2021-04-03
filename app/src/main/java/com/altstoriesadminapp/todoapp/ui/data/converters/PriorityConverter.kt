package com.altstoriesadminapp.todoapp.ui.data.converters

import androidx.room.TypeConverter
import com.altstoriesadminapp.todoapp.ui.data.Priority

class PriorityConverter {

    @TypeConverter
    fun fromPriority(priority: Priority): String{
        return priority.name
    }
    @TypeConverter
    fun fromString(priority: String): Priority{
        return Priority.valueOf(priority)
    }
}