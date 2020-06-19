package com.example.tamazhomework7

import android.app.Application
import com.example.tamazhomework7.api.RetrofitClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }
}

