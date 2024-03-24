package com.hycomist.todoapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation


fun Navigation.startFragment(it: View,id: Int) {
   findNavController(it).navigate(id)
}

fun Navigation.startFragment(it: View,id: NavDirections) {
   findNavController(it).navigate(id)
}