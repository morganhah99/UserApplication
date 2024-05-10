package com.example.userapplication.injection.module

import com.example.userapplication.repository.UserRepositoryImplementation
import com.example.userapplication.injection.dependency.provideUserRepository
import com.example.userapplication.repository.UserRepository
import org.koin.dsl.module

val userModule = module {

    single<UserRepository> { UserRepositoryImplementation(get()) }
    factory { provideUserRepository(get()) }



}