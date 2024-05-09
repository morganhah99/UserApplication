package com.example.userapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userapplication.data.model.UserModel
import com.example.userapplication.databinding.ActivityMainBinding
import com.example.userapplication.network.api.ApiResponse
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userAdapter = UserAdapter()
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }

        lifecycleScope.launchWhenStarted {
            viewModel.userStateFlow.collect { response ->
                Log.d("MainActivity", "Received user data: $response")
                when (response) {
                    is ApiResponse.SuccessState -> {
                        val userList = response.data.map { dataModel ->
                            UserModel(data = listOf(dataModel))
                        }
                        userAdapter.submitList(userList)
                        Toast.makeText(this@MainActivity, "Success!", Toast.LENGTH_SHORT).show()
                    }
                    is ApiResponse.ErrorState -> {
                        Toast.makeText(this@MainActivity, "Error: ${response.message}", Toast.LENGTH_SHORT).show()
                    }
                    is ApiResponse.LoadingState -> {
                        Toast.makeText(this@MainActivity, "Loading...", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}