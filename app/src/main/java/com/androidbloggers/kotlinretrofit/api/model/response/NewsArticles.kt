package com.androidbloggers.workoutapplication.model

import com.google.gson.annotations.SerializedName

/**
 * Created On : 15/1/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class NewsArticles {
    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("urlToImage")
    var urlToImage: String? = null

    @SerializedName("content")
    var content: String? = null

    @SerializedName("url")
    var url : String? = null
}