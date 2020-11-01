package com.gtxtreme.mvvmnews.repository.api

import com.gtxtreme.mvvmnews.model.News
import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") countryCode: String?,
        @Query("apiKey") apiKey: String?
    ): Call<News>
}
