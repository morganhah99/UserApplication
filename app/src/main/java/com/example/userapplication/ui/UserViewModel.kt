package com.example.userapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.data.model.UserModel
import com.example.userapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userLiveData = MutableLiveData<UserModel>()

    fun fetchUsersResponse() {
        viewModelScope.launch {
            val response = userRepository.getResponse()

            if (response.isSuccessful) {
                val results = response.body()
                userLiveData.postValue(results)
            }
        }
    }
}