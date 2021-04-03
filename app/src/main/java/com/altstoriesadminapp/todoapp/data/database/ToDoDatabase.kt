package com.altstoriesadminapp.todoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.altstoriesadminapp.todoapp.data.converters.PriorityConverter
import com.altstoriesadminapp.todoapp.data.dao.ToDoDao
import com.altstoriesadminapp.todoapp.data.entities.ToDoData

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(PriorityConverter::class)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object{
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                ToDoDatabase::class.java,
                "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}