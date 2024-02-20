package com.mycompany.addnamesavedata1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.addnamesavedata1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonAddName.setOnClickListener {
            val name = binding.editTextName.text.toString()
            if (name.isNotEmpty()) {
                viewModel.addName(name)
                binding.textViewNames.text = viewModel.getNamesAsString()
                binding.textViewNames.visibility = View.VISIBLE
            } else {
                binding.textViewNames.text = getString(R.string.no_name_entered)
                binding.textViewNames.visibility = View.VISIBLE
            }
            binding.editTextName.text.clear()
        }

        if (viewModel.getNamesAsString().isNotEmpty()) {
            binding.textViewNames.visibility = View.VISIBLE
            binding.textViewNames.text = viewModel.getNamesAsString()
        }
    }
}