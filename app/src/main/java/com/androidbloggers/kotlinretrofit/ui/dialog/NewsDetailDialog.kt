package com.androidbloggers.kotlinretrofit.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.androidbloggers.kotlinretrofit.R
import com.androidbloggers.workoutapplication.model.NewsArticles
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_detail_popup.*

/**
 * Created On : 8/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class NewsDetailDialog(context: Context, val newsArticles: NewsArticles) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_detail_popup)
        title_text.text = newsArticles.title
        description_text.text = newsArticles.description
        Glide.with(context).load(newsArticles.urlToImage)
                .error(R.drawable.transparent_background)
                .into(article_image)
        cancel_dialog.setOnClickListener {
            dismiss()
        }

        view_article.setOnClickListener {
            val intent : Intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsArticles.url))
            context.startActivity(intent)
            dismiss()
        }
    }

}