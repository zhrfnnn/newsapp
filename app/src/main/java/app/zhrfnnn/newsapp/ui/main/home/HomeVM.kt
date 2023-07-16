package app.zhrfnnn.newsapp.ui.main.home

import androidx.lifecycle.MutableLiveData
import app.zhrfnnn.newsapp.data.model.Article
import app.zhrfnnn.newsapp.data.usecase.news.GetHeadlinesUseCase
import app.zhrfnnn.newsapp.ui.base.BaseActivity
import app.zhrfnnn.newsapp.ui.base.BaseVM
import app.zhrfnnn.newsapp.util.log
import javax.inject.Inject

/**
 * Created by Zharfan on 7/16/2023.
 */

class HomeVM @Inject constructor(private val activity: BaseActivity,
                                 private val getHeadlinesUseCase: GetHeadlinesUseCase) : BaseVM(){

    val articlesData = MutableLiveData<List<Article>>()
    val articles = arrayListOf<Article>()

    fun getHeadlines(){
        getHeadlinesUseCase.execute(
            onStart = {},
            onSuccess = { response ->
                if(response.isSuccess()){
                    response.articles?.also { articlesResponse ->
                        articlesData.postValue(articlesResponse)
                    }
                } else {
                    log("${response.code} - ${response.message}")
                }
            },
            onError = {
                it.localizedMessage?.also { error -> log(error) }
            },
            onFinished = {}
        )
    }
}