package com.altstoriesadminapp.todoapp.ui.fragments.update

import android.os.Bundle
import android.view.*
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.altstoriesadminapp.todoapp.R
import com.altstoriesadminapp.todoapp.data.model.Priority
import com.altstoriesadminapp.todoapp.databinding.FragmentUpdateBinding
import com.altstoriesadminapp.todoapp.viewmodel.SharedViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private val binding: FragmentUpdateBinding by viewBinding()
    prival val sharedViewModel: SharedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        binding.titleEdittextUpdateFrag.setText(args.currentItem.title)
        binding.descriptionEdittextUpdateFrag.setText(args.currentItem.description)
        binding.priotitySpinnerUpdateFrag.setSelection(parsePriority(args.currentItem.priority))
        binding.priotitySpinnerUpdateFrag.onItemSelectedListener = sharedViewModel.listener

    }

    private fun parsePriority(priority: Priority): Int {
        return when(priority){
            Priority.LOW -> 2
            Priority.MEDIUM -> 1
            Priority.HIGH -> 0
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu,menu)
    }

}