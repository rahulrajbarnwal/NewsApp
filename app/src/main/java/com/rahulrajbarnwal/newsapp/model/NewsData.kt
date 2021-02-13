package com.rahulrajbarnwal.newsapp.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(primaryKeys = ["title"])
data class NewsData (
    val title: String,
    val description: String,
    val author: String,
    @SerializedName("urlToImage")
    val url_to_image: String,

    @SerializedName("publishedAt")
    val published_at: String,
    val source: Source,
    val url:String,
    val content:String

) : Serializable

{
    data class Source(
        val name: String
    ) : Serializable
}
