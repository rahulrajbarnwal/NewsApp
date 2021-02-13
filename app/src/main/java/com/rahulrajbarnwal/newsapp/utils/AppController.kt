package com.rahulrajbarnwal.newsapp.utils

import android.app.Application
import com.rahulrajbarnwal.newsapp.api.*

class Appcontroller : Application() {

    lateinit var mApiComponent: ApiComponent

    override fun onCreate() {
        super.onCreate()
        app = this

        mApiComponent = DaggerApiComponent.builder()
            .appModule(AppModule(this))
            .apiHelper(ApiHelper())
            .dBModule(DBModule(this))
            .build()

    }

    companion object {
        lateinit var app: Appcontroller
            private set
    }
}