package com.example.userapplication.repository

import com.example.userapplication.data.model.UserModel
import retrofit2.Response

interface UserRepository {
    suspend fun getResponse(): Response<UserModel>
}