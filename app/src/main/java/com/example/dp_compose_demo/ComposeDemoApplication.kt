package com.example.dp_compose_demo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}