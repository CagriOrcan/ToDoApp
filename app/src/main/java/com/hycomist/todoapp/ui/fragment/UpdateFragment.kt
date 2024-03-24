package com.hycomist.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.hycomist.todoapp.R
import com.hycomist.todoapp.databinding.FragmentUpdateBinding
import com.hycomist.todoapp.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: UpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temViewModel: UpdateViewModel by viewModels()
        viewModel = temViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater,container,false)

        val bundle: UpdateFragmentArgs by navArgs()

        val toDo = bundle.toDo

        binding.etUpdateName.setText(toDo.name)

        binding.btnUpdate.setOnClickListener {
            val name = binding.etUpdateName.text.toString()
            viewModel.update(toDo.id,name)
            Navigation.findNavController(it).navigate(R.id.mainFragment)
        }

        return binding.root
    }



}