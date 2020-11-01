package com.gtxtreme.mvvmnews.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gtxtreme.mvvmnews.model.Article
import com.gtxtreme.mvvmnews.model.News
import com.gtxtreme.mvvmnews.repository.NewsRepository
import com.gtxtreme.mvvmnews.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class NewsViewModel constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getAllPostsFromRepository(): MutableLiveData<List<Article>> {
        val mutableNewsData = MutableLiveData<List<Article>>()
        var articles: List<Article> = listOf()
        newsRepository.getAllPosts("in", Constants.API_KEY).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null && news.articles.isNotEmpty()) {
                    articles = news.articles
                }
                mutableNewsData.value = articles
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return mutableNewsData
    }
}