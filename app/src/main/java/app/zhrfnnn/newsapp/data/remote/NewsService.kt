package app.zhrfnnn.newsapp.data.remote

import app.zhrfnnn.newsapp.data.model.headlines.HeadlinesResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Zharfan on 7/16/2023.
 */

interface NewsService {

    @GET("v2/top-headlines")
    fun getHeadlines(
        @Query("country") countryCode: String = "us", //us
        @Query("category") category: String = "technology",
        @Query("page") pageNumber: Int = 1,
        @Query("pageSize") pageSize: Int = 50,
    ): Single<Response<HeadlinesResponse>>
}