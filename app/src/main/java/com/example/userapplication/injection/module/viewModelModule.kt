package com.example.userapplication.injection.module

import com.example.userapplication.ui.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { UserViewModel(get()) }

}