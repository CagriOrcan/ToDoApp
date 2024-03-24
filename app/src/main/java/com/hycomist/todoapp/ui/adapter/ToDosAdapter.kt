package com.hycomist.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hycomist.todoapp.data.entity.ToDos
import com.hycomist.todoapp.databinding.FragmentUpdateBinding
import com.hycomist.todoapp.databinding.ItemCardDesignBinding
import com.hycomist.todoapp.ui.fragment.MainFragmentDirections
import com.hycomist.todoapp.ui.viewmodel.MainViewModel
import com.hycomist.todoapp.utils.startFragment

class ToDosAdapter(var mContext:Context,var toDosList: List<ToDos>,var viewModel: MainViewModel)
    : RecyclerView.Adapter<ToDosAdapter.CardDesignViewHolder>() {

    inner class CardDesignViewHolder(var binding: ItemCardDesignBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignViewHolder {
        val binding = ItemCardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)

        return CardDesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignViewHolder, position: Int) {
        val toDo = toDosList.get(position)
        val design = holder.binding
        design.tvName.text = toDo.name

        design.cardViewRow.setOnClickListener {
            val toUpdateScreen = MainFragmentDirections.toUpdateScreen(toDo)

            Navigation.startFragment(it,toUpdateScreen)
        }

        design.imgDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete? ${toDo.name}",Snackbar.LENGTH_SHORT)
                .setAction("YES") {
                    viewModel.delete(id = toDo.id)
                }.show()
        }


    }

    override fun getItemCount(): Int {
       return toDosList.size
    }

}
