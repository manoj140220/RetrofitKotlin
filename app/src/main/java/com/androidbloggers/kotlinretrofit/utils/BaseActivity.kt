package com.androidbloggers.kotlinretrofit.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created On : 8/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun getView() : Int
    abstract fun viewCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
        viewCreated(savedInstanceState)
    }

    fun getBaseApplication() : BaseApplication{
        return applicationContext as BaseApplication
    }
}