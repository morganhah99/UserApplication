package com.example.userapplication.injection

import com.example.userapplication.data.model.UserModel
import com.example.userapplication.network.api.UserAPIService
import retrofit2.Response

class UserAPIServiceImplementation(private val apiService: UserAPIService) : UserAPIService {

    override suspend fun getResponse(): Response<UserModel> {
        return apiService.getResponse()
    }
}