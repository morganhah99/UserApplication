package com.example.userapplication.repository

import com.example.userapplication.network.api.UserAPIService
import com.example.userapplication.repository.UserRepository

class UserRepositoryImplementation(private val service: UserAPIService): UserRepository {

    override suspend fun getResponse() = service.getResponse()
}