package com.example.userapplication.injection

import com.example.userapplication.network.api.UserAPIService
import com.example.userapplication.repository.UserRepository
import com.example.userapplication.ui.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<UserAPIService> { UserAPIServiceImplementation(get()) }
    single<UserRepository> { UserRepositoryImplementation(get()) }
    single { provideApiServiceObject(get()) }
    viewModel { UserViewModel(get()) }
    factory { provideUserRepository(get()) }

}