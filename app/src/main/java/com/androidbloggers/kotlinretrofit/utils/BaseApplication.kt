package com.androidbloggers.kotlinretrofit.utils

import android.app.Application
import com.androidbloggers.kotlinretrofit.background.RetrofitInit

/**
 * Created On : 1/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class BaseApplication : Application() {

    private var retrofitInit : RetrofitInit ?= null

    override fun onCreate() {
        super.onCreate()
        retrofitInit = RetrofitInit(this)
    }

    fun getRetrofitInitObject() : RetrofitInit{
        return retrofitInit!!
    }
}