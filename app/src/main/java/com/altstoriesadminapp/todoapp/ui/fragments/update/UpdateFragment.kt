package com.altstoriesadminapp.todoapp.ui.fragments.update

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.altstoriesadminapp.todoapp.R
import com.altstoriesadminapp.todoapp.databinding.FragmentUpdateBinding
import com.altstoriesadminapp.todoapp.viewmodel.SharedViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private val binding: FragmentUpdateBinding by viewBinding()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        setUpBinding()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_save) {

        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpBinding() {
        binding.titleEdittextUpdateFrag.setText(args.currentItem.title)
        binding.descriptionEdittextUpdateFrag.setText(args.currentItem.description)
        binding.priotitySpinnerUpdateFrag.setSelection(sharedViewModel.parsePriorityToInt(args.currentItem.priority))
        binding.priotitySpinnerUpdateFrag.onItemSelectedListener = sharedViewModel.listener
    }


}