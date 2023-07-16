package app.zhrfnnn.newsapp.ui.base

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Zharfan on 7/16/2023.
 */

abstract class BaseVM : ViewModel() {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var disposable : CompositeDisposable

    var onBackObservable = MutableLiveData<Boolean>()

    open fun onPressingBack(){
        onBackObservable.postValue(true)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}