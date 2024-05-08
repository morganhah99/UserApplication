package com.example.userapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.userapplication.R
import com.example.userapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()

        binding.rvMain.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.fetchUsersResponse()

        viewModel.userLiveData.observe(this) { users ->
            adapter.submitList(users.data)
        }
    }
}