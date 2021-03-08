package com.androidbloggers.kotlinretrofit.ui.adapter

import android.content.Context
import android.text.Html
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.androidbloggers.kotlinretrofit.R
import com.androidbloggers.kotlinretrofit.ui.adapter.itemview.TopHeadingsItemView
import com.androidbloggers.kotlinretrofit.ui.dialog.NewsDetailDialog
import com.androidbloggers.workoutapplication.model.NewsArticles
import com.bumptech.glide.Glide

/**
 * Created On : 8/3/21
 * Author     : Manoj Basavaraja
 * Name       : Manoj DB
 */
class TopHeadingsAdapter(private val context: Context,
                         private val newsArticles : MutableList<NewsArticles>)
    : RecyclerView.Adapter<TopHeadingsItemView>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadingsItemView {
        return TopHeadingsItemView(parent, R.layout.news_list_item)
    }

    override fun getItemCount(): Int {
        return newsArticles.size
    }

    override fun onBindViewHolder(holder: TopHeadingsItemView, position: Int) {
        if(newsArticles[position].description != null && newsArticles[position].description!!.length > context.resources.getInteger(R.integer.text_max_length)){
            holder.descriptionText!!.text = HtmlCompat.fromHtml(
                newsArticles[position].description!!.substring(0, 150)
                        + "..." + "<font color='white'> <b><u>View More</u></b></font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY)
        }else{
            if(newsArticles[position].description == null)
                holder.descriptionText!!.text = ""
            else
                holder.descriptionText!!.text = newsArticles[position].description!!
        }

        holder.titleText!!.text = newsArticles[position].title

        Glide.with(context)
                .load(newsArticles[position].urlToImage)
                .into(holder.articleImage!!)

        holder.descriptionText!!.setOnClickListener {
            if (holder.descriptionText!!.text.toString().endsWith("View More")) {
                val newsAlertDialog = NewsDetailDialog(context, newsArticles[position])
                newsAlertDialog.setCancelable(false)
                newsAlertDialog.show()
                val window: Window = newsAlertDialog.window!!
                window.setLayout(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
                window.setBackgroundDrawableResource(android.R.color.transparent)
            }else{
                if (newsArticles[position].description != null && newsArticles[position].description!!.length > context.resources.getInteger(R.integer.text_max_length)) {
                    holder.descriptionText!!.text = HtmlCompat.fromHtml(
                        newsArticles[position].description!!.substring(0, 150)
                                + "..." + "<font color='white'> <b><u>View More</u></b></font>",
                        HtmlCompat.FROM_HTML_MODE_LEGACY)
                } else {
                    if(newsArticles[position].description == null)
                        holder.descriptionText!!.text = ""
                    else
                        holder.descriptionText!!.text = newsArticles[position].description!!
                }
            }
        }
    }
}