package com.example.userapplication.injection

import com.example.userapplication.network.api.UserAPIService
import com.example.userapplication.repository.UserRepository
import okhttp3.Cache
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import okhttp3.OkHttpClient
import android.content.Context
import com.example.userapplication.network.interceptors.LoggingInterceptor





fun provideApiServiceObject(context: Context): UserAPIService {
    val cacheSize = 20L * 1024L * 1024L // 20 MB
    val cache = Cache(File(context.cacheDir, "http_cache"), cacheSize)
    val okHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(LoggingInterceptor())
        .addInterceptor(com.example.userapplication.network.interceptors.CachingInterceptor())
        .addNetworkInterceptor(com.example.userapplication.network.interceptors.CachingInterceptor())
        .build()

    return Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPIService::class.java)
}

fun provideUserRepository(userAPIService: UserAPIService): UserRepository {
    return UserRepositoryImplementation(userAPIService)
}

