package com.rahulrajbarnwal.newsapp.api

import com.rahulrajbarnwal.newsapp.model.BaseModel
import com.rahulrajbarnwal.newsapp.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.ArrayList

interface NewsApi {
    @GET("top-headlines")
    fun getPaymentTypes(@Query("country") country: String, @Query("apiKey") apiKey: String, @Query("pageSize") page: Int): Call<BaseModel<ArrayList<NewsData>>>

}