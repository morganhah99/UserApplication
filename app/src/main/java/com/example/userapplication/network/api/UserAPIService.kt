package com.example.userapplication.network.api

import com.example.userapplication.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UserAPIService {

    @GET("api/users")
    suspend fun getResponse(): Response<UserModel>
}