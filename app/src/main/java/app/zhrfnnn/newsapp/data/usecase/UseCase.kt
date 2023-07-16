package app.zhrfnnn.newsapp.data.usecase

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Zharfan on 7/16/2023.
 */

abstract class UseCase {

    protected var lastDisposable: Disposable? = null
    @Inject protected lateinit var compositeDisposable : CompositeDisposable

    fun disposeLast() {
        lastDisposable?.also {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}