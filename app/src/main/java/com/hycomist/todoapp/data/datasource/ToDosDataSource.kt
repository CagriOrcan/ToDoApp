package com.hycomist.todoapp.data.datasource

import android.util.Log
import com.hycomist.todoapp.data.entity.ToDos
import com.hycomist.todoapp.retrofit.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {
    suspend fun save(name: String) {
        toDosDao.save(name)
    }

    suspend fun update(id: Int,name: String) {
        toDosDao.update(id,name)
    }

    suspend fun delete(id: Int) {
        toDosDao.delete(id)
    }

    suspend fun loadToDos(): List<ToDos> = withContext(Dispatchers.IO) {

        return@withContext toDosDao.loadToDos().toDos
    }
    suspend fun search(searchText: String): List<ToDos> = withContext(Dispatchers.IO) {

        return@withContext toDosDao.search(searchText).toDos
    }
}