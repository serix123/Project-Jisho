package com.example.appnavfragment

import android.app.Application
import com.example.appnavfragment.dependency_injection.AppModule
import dagger.Component
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Singleton

@HiltAndroidApp
class MainApplication:Application() {

    @Component(modules = [AppModule::class])
    @Singleton
    interface SingletonComponent

}