package app.zhrfnnn.newsapp.data.usecase.news

import app.zhrfnnn.newsapp.data.model.headlines.HeadlinesResponse
import app.zhrfnnn.newsapp.data.repo.NewsRepo
import app.zhrfnnn.newsapp.data.usecase.SingleUseCase
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Zharfan on 7/16/2023.
 */

class GetHeadlinesUseCase @Inject constructor(private val newsRepo: NewsRepo) : SingleUseCase<HeadlinesResponse>() {

    override fun buildUseCaseObservable(): Single<Response<HeadlinesResponse>> {
        return newsRepo.getHeadlines()
    }
}