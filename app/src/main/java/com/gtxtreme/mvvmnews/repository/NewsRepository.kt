package com.gtxtreme.mvvmnews.repository

import com.gtxtreme.mvvmnews.model.News
import com.gtxtreme.mvvmnews.repository.api.NewsService
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton


// This class will be the top layer for all data the application deals with
// Single Source of Data for the entire application

@Singleton
class NewsRepository @Inject constructor(
    private val newsService: NewsService
){
    fun getAllPosts(countryId:String,apiKey:String): Call<News> {
        return newsService.getTopHeadlines(countryId,apiKey)
    }
}