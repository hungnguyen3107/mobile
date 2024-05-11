package com.example.theweatherapp.db
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.theweatherapp.models.Article
import androidx.room.Query
@Dao
interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long
    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>
    @Delete
    suspend fun deleteArticle(article: Article)
}