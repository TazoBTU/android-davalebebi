package com.example.covid19app

import android.app.Application
import com.example.covid19app.covidapi.RetrofitClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }
}