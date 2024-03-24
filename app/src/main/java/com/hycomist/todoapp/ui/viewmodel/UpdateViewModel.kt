package com.hycomist.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.hycomist.todoapp.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var toDosRepo: ToDosRepository): ViewModel() {
    fun update(id:Int, name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepo.update(id,name)
        }
    }
}