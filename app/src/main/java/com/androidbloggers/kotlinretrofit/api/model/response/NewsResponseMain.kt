package com.androidbloggers.workoutapplication.model

import com.google.gson.annotations.SerializedName

/**
 * Created On : 15/1/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class NewsResponseMain {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults = 0

    @SerializedName("articles")
    var articles: MutableList<NewsArticles>? = null
}