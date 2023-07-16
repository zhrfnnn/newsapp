package app.zhrfnnn.newsapp

import android.app.Application
import app.zhrfnnn.newsapp.di.ApplicationComponent
import app.zhrfnnn.newsapp.di.DaggerApplicationComponent
import app.zhrfnnn.newsapp.di.module.ApplicationModule
import app.zhrfnnn.newsapp.di.module.NetworkModule

/**
 * Created by Zharfan on 7/16/2023.
 */

class App : Application() {

    companion object {
        lateinit var instance : App private set
    }

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        inject()
    }

    private fun inject() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule())
            .build()
        component.inject(this)
    }
}