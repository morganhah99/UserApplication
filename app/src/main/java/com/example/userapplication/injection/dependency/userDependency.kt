package com.example.userapplication.injection.dependency

import com.example.userapplication.repository.UserRepositoryImplementation
import com.example.userapplication.network.api.UserAPIService
import com.example.userapplication.repository.UserRepository

fun provideUserRepository(userAPIService: UserAPIService): UserRepository {
    return UserRepositoryImplementation(userAPIService)
}