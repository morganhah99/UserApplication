package com.example.userapplication.repository

import com.example.userapplication.network.api.UserAPIService
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: UserAPIService) {

    suspend fun getResponse() = service.getResponse()
}