package com.gtxtreme.mvvmnews.di.module

import com.gtxtreme.mvvmnews.repository.api.NewsService
import com.gtxtreme.mvvmnews.util.Constants
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

class NewsApiModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): NewsService = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(NewsService::class.java)
}