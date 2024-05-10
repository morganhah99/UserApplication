package com.example.userapplication

import android.app.Application
import com.example.userapplication.injection.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class UserApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@UserApplication)
            modules(appModule)
        }
    }
}