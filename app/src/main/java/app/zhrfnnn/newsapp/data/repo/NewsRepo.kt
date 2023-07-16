package app.zhrfnnn.newsapp.data.repo

import app.zhrfnnn.newsapp.data.model.headlines.HeadlinesResponse
import io.reactivex.Single
import retrofit2.Response

/**
 * Created by Zharfan on 7/16/2023.
 */
interface NewsRepo {
    fun getHeadlines() : Single<Response<HeadlinesResponse>>
}