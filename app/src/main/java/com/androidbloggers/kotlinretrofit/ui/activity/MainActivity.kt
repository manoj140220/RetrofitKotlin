package com.androidbloggers.kotlinretrofit.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidbloggers.kotlinretrofit.R
import com.androidbloggers.kotlinretrofit.api.interfaces.TopHeadings
import com.androidbloggers.kotlinretrofit.api.model.request.TopHeadingsRequest
import com.androidbloggers.kotlinretrofit.ui.adapter.TopHeadingsAdapter
import com.androidbloggers.kotlinretrofit.utils.BaseActivity
import com.androidbloggers.workoutapplication.model.NewsArticles
import com.androidbloggers.workoutapplication.model.NewsResponseMain
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private val country = "in"
    private var page = 1
    private val pageCount = 10
    private var totalResult : Int = 0
    private var newsArticleData : MutableList<NewsArticles> = ArrayList<NewsArticles>()
    private var newsArticleAdapter : TopHeadingsAdapter ?= null

    override fun getView(): Int {
        return R.layout.activity_main
    }

    override fun viewCreated(savedInstanceState: Bundle?) {
        val articleListView : RecyclerView = findViewById(R.id.news_article_list)
        articleListView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        newsArticleAdapter = TopHeadingsAdapter(this@MainActivity, newsArticleData)
        articleListView.adapter = newsArticleAdapter

        callApi()

        articleListView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(articleListView.canScrollVertically(1)){
                    if(newsArticleData.size < totalResult){
                        page++
                        callApi()
                    }
                }
            }
        })
    }

    private fun callApi() {
        GlobalScope.launch {
            async {
                val topHeadings = TopHeadingsRequest(country, page, pageCount,
                        getBaseApplication().getRetrofitInitObject().getRetrofitObject().create(TopHeadings::class.java))
                topHeadings.getServiceApi(
                        {newsResponseMain -> onSuccess(newsResponseMain) },
                        {errorString -> onErrorResponse(errorString)})
            }
        }
    }

    private fun onErrorResponse(errorString: String) {
        Toast.makeText(this@MainActivity, errorString, Toast.LENGTH_SHORT).show()
    }

    private fun onSuccess(newsResponseMain: NewsResponseMain) {
        if(totalResult == 0)
            totalResult = newsResponseMain.totalResults

        newsArticleData.addAll(newsResponseMain.articles!!)

        //Notify Adapter
        newsArticleAdapter!!.notifyDataSetChanged()
    }
}