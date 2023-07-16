package app.zhrfnnn.newsapp.di.module

import android.content.Context
import app.zhrfnnn.newsapp.App
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Zharfan on 7/16/2023.
 */

@Module
class ApplicationModule(private val application: App) {

    @Provides
    @Singleton
    fun provideApplication() : App {
        return application
    }

    @Provides
    fun provideContext() : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }
}