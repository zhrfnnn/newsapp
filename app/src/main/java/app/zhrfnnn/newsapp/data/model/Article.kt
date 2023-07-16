package app.zhrfnnn.newsapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Zharfan on 7/16/2023.
 */

data class Article(
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var imageUrl: String? = null,
    @SerializedName("publishedAt") var publishedAt: String? = null,
    @SerializedName("content") var content: String? = null,
)
