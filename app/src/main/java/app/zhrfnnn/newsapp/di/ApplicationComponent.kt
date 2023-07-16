package app.zhrfnnn.newsapp.di

import app.zhrfnnn.newsapp.App
import app.zhrfnnn.newsapp.di.module.ApplicationModule
import app.zhrfnnn.newsapp.di.module.NetworkModule
import app.zhrfnnn.newsapp.di.module.ScreenModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Zharfan on 7/16/2023.
 */

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun inject(app : App)

    fun plus(screenModule: ScreenModule): ScreenComponent
}