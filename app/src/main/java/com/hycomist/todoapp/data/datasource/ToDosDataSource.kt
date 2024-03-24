package com.hycomist.todoapp.data.datasource

import android.util.Log
import com.hycomist.todoapp.data.entity.ToDos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource {
    suspend fun save(name: String) {
        Log.e("ToDoAppOut Save",name)
    }

    suspend fun update(id: Int,name: String) {
        Log.e("ToDoAppOut Update","$id - $name")
    }

    suspend fun delete(id: Int) {
        Log.e("ToDoAppOut Delete",id.toString())
    }

    suspend fun loadToDos(): List<ToDos> = withContext(Dispatchers.IO) {
        val toDoList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport")
        val toDo2 = ToDos(2,"Movie")
        val toDo3 = ToDos(3,"Software")
        toDoList.add(toDo1)
        toDoList.add(toDo2)
        toDoList.add(toDo3)

        return@withContext toDoList
    }
    suspend fun search(searchText: String): List<ToDos> = withContext(Dispatchers.IO) {
        val toDoList = ArrayList<ToDos>()
        val toDo1 = ToDos(1,"Sport")
        toDoList.add(toDo1)


        return@withContext toDoList
    }
}