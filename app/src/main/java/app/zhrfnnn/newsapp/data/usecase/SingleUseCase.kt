package app.zhrfnnn.newsapp.data.usecase

import app.zhrfnnn.newsapp.util.addTo
import app.zhrfnnn.newsapp.util.applySingleAsync
import io.reactivex.Single
import retrofit2.Response

/**
 * Created by Zharfan on 7/16/2023.
 */

abstract class SingleUseCase<Z> : UseCase() {

    internal abstract fun buildUseCaseObservable(): Single<Response<Z>>

    fun execute(onStart : () -> Unit,
                onSuccess: (t : Z) -> Unit,
                onError: (t: Throwable) -> Unit,
                onFinished: () -> Unit = {}) {
        disposeLast()
        lastDisposable = buildUseCaseObservable()
            .compose(applySingleAsync())
            .doOnSubscribe{onStart()}
            .doAfterTerminate{onFinished()}
            .subscribe({
                it.body()?.also { response ->
                    response.also(onSuccess)
                }
            },{
                it.message?.also { message ->
                    if (message.contains("address associated with hostname")){
                        onError(Throwable("There was a problem connecting to host"))
                        return@subscribe
                    }
                    onError(it)
                }
            })
        lastDisposable?.addTo(compositeDisposable)
    }
}