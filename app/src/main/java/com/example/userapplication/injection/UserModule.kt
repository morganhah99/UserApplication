package com.example.userapplication.injection

import com.example.userapplication.network.api.UserAPIService
import com.example.userapplication.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Singleton
    @Provides
    fun provideAPIService(): UserAPIService =
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPIService::class.java)

    @Singleton
    @Provides
    fun provideUserRepository(): UserRepository =
        UserRepository(provideAPIService())
}