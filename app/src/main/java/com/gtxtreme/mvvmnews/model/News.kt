package com.gtxtreme.mvvmnews.model


data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

