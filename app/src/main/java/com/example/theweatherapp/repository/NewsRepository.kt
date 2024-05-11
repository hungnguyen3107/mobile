package com.example.theweatherapp.repository

import com.example.theweatherapp.api.RetrofitInstance
import com.example.theweatherapp.db.ArticleDatabase
import com.example.theweatherapp.models.Article
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadline(countryCode: String,pageNumber: Int) =
        RetrofitInstance.api.getHeadline(countryCode, pageNumber)
    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
    fun getFavoriteNews() = db.getArticleDao().getAllArticles()
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}