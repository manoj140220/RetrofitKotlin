package com.androidbloggers.kotlinretrofit.api.model.request

import com.androidbloggers.kotlinretrofit.api.interfaces.TopHeadings
import com.androidbloggers.kotlinretrofit.background.ApiService
import com.androidbloggers.workoutapplication.model.NewsResponseMain
import okhttp3.ResponseBody
import retrofit2.Call
import java.lang.reflect.Type

/**
 * Created On : 1/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class TopHeadingsRequest(private val county : String,
                         private val page : Int,
                         private val pageSize : Int,
                         private val topHeadings: TopHeadings)
    : ApiService<TopHeadings, NewsResponseMain>() {

    override fun getService(): TopHeadings {
        return topHeadings
    }

    override fun getCall(service: TopHeadings): Call<ResponseBody> {
        return service.getTopHeadings(county, page, pageSize)
    }

    override fun getClassType(): Type? {
        return NewsResponseMain::class.java
    }
}