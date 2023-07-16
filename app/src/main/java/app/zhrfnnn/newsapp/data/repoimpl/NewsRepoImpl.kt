package app.zhrfnnn.newsapp.data.repoimpl

import app.zhrfnnn.newsapp.data.model.headlines.HeadlinesResponse
import app.zhrfnnn.newsapp.data.remote.NewsService
import app.zhrfnnn.newsapp.data.repo.NewsRepo
import io.reactivex.Single
import retrofit2.Response

/**
 * Created by Zharfan on 7/16/2023.
 */

class NewsRepoImpl(private val newsService: NewsService) : NewsRepo {

    override fun getHeadlines(): Single<Response<HeadlinesResponse>> {
        return newsService.getHeadlines()
    }
}