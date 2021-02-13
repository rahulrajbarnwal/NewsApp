package com.rahulrajbarnwal.newsapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rahulrajbarnwal.newsapp.model.NewsData

@Dao
interface NewsDao {

    //insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @JvmSuppressWildcards
    fun insertNews(news: NewsData?):Long

    //get all news
    @Query("SELECT * FROM NewsData order by published_at desc")
    fun getNews(): List<NewsData>
}
