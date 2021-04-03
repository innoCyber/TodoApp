package com.altstoriesadminapp.todoapp.ui.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.altstoriesadminapp.todoapp.R
import com.altstoriesadminapp.todoapp.data.entities.ToDoData
import com.altstoriesadminapp.todoapp.data.model.Priority
import com.altstoriesadminapp.todoapp.databinding.FragmentAddBinding
import com.altstoriesadminapp.todoapp.viewmodel.ToDoViewModel

class AddFragment : Fragment(R.layout.fragment_add) {

    val binding: FragmentAddBinding by viewModels()
    val toDoViewModel: ToDoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add){
            insertDataToDb()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val title = binding.titleEdittext.text.toString()
        val priority = binding.priotitySpinner.selectedItem.toString()
        val description = binding.descriptionEdittext.text.toString()

        val validation = verifyDataFromUser(title, description)
        if (validation){
            val newData = ToDoData(
                0,
                title,
                parsePriority(priority),
                description
            )

            toDoViewModel.insertData(newData)
            Toast.makeText(requireContext(),"Added Successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Fill all fields to continue ", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyDataFromUser(title: String, description: String): Boolean{
        return if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
            false
        }else !(title.isEmpty() || description.isEmpty())
    }

    private fun parsePriority(priority: String): Priority{
        return when(priority){
            "High Priority" -> Priority.HIGH
            "Medium Priority" -> Priority.MEDIUM
            "Low Priority" -> Priority.LOW
            else -> Priority.LOW
        }
    }

}