package com.hycomist.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.hycomist.todoapp.R
import com.hycomist.todoapp.databinding.FragmentMainBinding
import com.hycomist.todoapp.ui.adapter.ToDosAdapter
import com.hycomist.todoapp.ui.viewmodel.MainViewModel
import com.hycomist.todoapp.utils.startFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temViewModel: MainViewModel by viewModels()
        viewModel = temViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.toDosList.observe(viewLifecycleOwner) { toDoList ->
            val toDosAdapter = ToDosAdapter(requireContext(),toDoList,viewModel)
            binding.recyclerView.adapter = toDosAdapter
            binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        }

        binding.floatingActionButton.setOnClickListener {
            Navigation.startFragment(it,R.id.toSaveScreen)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // Harf girdikçe ve sildikçe çalışır
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean { // klavyedeki ara butonu ile çalışır
                viewModel.search(newText)
                return true
            }

        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadToDos()
    }

}