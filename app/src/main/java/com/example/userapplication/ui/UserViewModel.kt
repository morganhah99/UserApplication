package com.example.userapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.data.model.DataModel
import com.example.userapplication.network.api.ApiResponse
import com.example.userapplication.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _userStateFlow = MutableStateFlow<ApiResponse<List<DataModel>>>(ApiResponse.LoadingState())
    val userStateFlow: StateFlow<ApiResponse<List<DataModel>>> = _userStateFlow

    init {
        fetchUsersResponse()
    }

    private fun fetchUsersResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = userRepository.getResponse()

            if (response.isSuccessful) {
                val results = response.body()?.data ?: emptyList()
                _userStateFlow.emit(ApiResponse.SuccessState(results.filterNotNull()))
            } else {
                _userStateFlow.emit(ApiResponse.ErrorState("Failed to fetch data"))
            }
        }
    }
}