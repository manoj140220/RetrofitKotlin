package com.androidbloggers.kotlinretrofit.ui.adapter.itemview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidbloggers.kotlinretrofit.R

/**
 * Created On : 8/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class TopHeadingsItemView(viewGroup: ViewGroup, layout : Int) :
    RecyclerView.ViewHolder((LayoutInflater.from(viewGroup.context)
    .inflate(layout, viewGroup, false))) {

    var descriptionText : TextView ?= null
    var titleText : TextView ?= null
    var articleImage : ImageView ?= null

    init {
        descriptionText = itemView.findViewById(R.id.description_text)
        titleText = itemView.findViewById(R.id.title_text)
        articleImage = itemView.findViewById(R.id.article_image)
    }
}