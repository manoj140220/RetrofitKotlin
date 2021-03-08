package com.androidbloggers.kotlinretrofit.background

import android.content.Context
import com.androidbloggers.kotlinretrofit.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created On : 1/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class RetrofitInit(context: Context) {

    private var retrofit : Retrofit ?= null

    init {
        val gson : Gson = GsonBuilder().setLenient().create()
        retrofit = Retrofit.Builder()
                .baseUrl(context.getString(R.string.API_END_POINT))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getHttpClient())
                .build()
    }

    private fun getHttpClient(): OkHttpClient {
        val httpClient : OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(Interceptor { chain ->
            val request : Request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer c4285fe8f70d4b16b140f850bd83771c")
                    .build()
            return@Interceptor chain.proceed(request)
        })
        return httpClient.build()
    }

    fun getRetrofitObject() : Retrofit{
        return retrofit!!
    }
}