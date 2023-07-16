package app.zhrfnnn.newsapp.data.model.headlines

import app.zhrfnnn.newsapp.data.model.Article
import app.zhrfnnn.newsapp.data.model.GeneralResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Zharfan on 7/16/2023.
 */

class HeadlinesResponse : GeneralResponse() {
    @SerializedName("articles") var articles: List<Article>? = null
}