package com.example.userapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userapplication.data.model.UserModel
import com.example.userapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


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


        viewModel.userStateFlow
            .onEach { response ->
                Log.d("MainActivity", "Received user data: $response")
                val userList = response.map { dataModel ->
                    UserModel(data = listOf(dataModel))
                }
                userAdapter.submitList(userList)
            }
            .launchIn(lifecycleScope)
    }
}