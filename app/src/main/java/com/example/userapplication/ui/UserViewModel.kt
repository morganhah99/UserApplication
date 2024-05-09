package com.example.userapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.data.model.DataModel
import com.example.userapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _userStateFlow = MutableStateFlow<List<DataModel>>(emptyList())
    val userStateFlow: StateFlow<List<DataModel>> = _userStateFlow

    init {
        fetchUsersResponse()
    }

    private fun fetchUsersResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = userRepository.getResponse()

            if (response.isSuccessful) {
                val results = response.body()?.data ?: emptyList()
                _userStateFlow.emit(results.filterNotNull())
            }
        }
    }
}