package com.androidbloggers.kotlinretrofit.api.interfaces

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created On : 1/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
interface TopHeadings {
    @GET("top-headlines")
    fun getTopHeadings(@Query("country") country : String,
                       @Query("page") page : Int,
                       @Query("pageSize") pageSize : Int) : Call<ResponseBody>
}