package com.hycomist.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hycomist.todoapp.data.entity.ToDos
import com.hycomist.todoapp.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var toDosRepo: ToDosRepository): ViewModel() {
    var toDosList = MutableLiveData<List<ToDos>>()
    init {
        loadToDos()
    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepo.delete(id)
            loadToDos()
        }
    }

    fun loadToDos() {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepo.loadToDos()
        }
    }

    fun search(searchText: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepo.search(searchText)
        }
    }
}