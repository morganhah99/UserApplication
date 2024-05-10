package com.example.userapplication.injection.module

import com.example.userapplication.repository.UserAPIServiceImplementation
import com.example.userapplication.injection.dependency.provideApiServiceObject
import com.example.userapplication.network.api.UserAPIService
import org.koin.dsl.module

val apiModule = module {

    single<UserAPIService> { UserAPIServiceImplementation(get()) }
    single { provideApiServiceObject(get()) }

}