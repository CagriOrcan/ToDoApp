package com.hycomist.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hycomist.todoapp.databinding.FragmentSaveBinding
import com.hycomist.todoapp.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    private val viewModel: SaveViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater,container,false)

        binding.btnSave.setOnClickListener {
            val name = binding.etUpdateName.text.toString()
            viewModel.save(name)

        }

        return binding.root
    }

}