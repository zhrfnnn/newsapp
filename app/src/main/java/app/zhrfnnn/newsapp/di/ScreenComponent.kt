package app.zhrfnnn.newsapp.di

import app.zhrfnnn.newsapp.di.module.ScreenModule
import app.zhrfnnn.newsapp.ui.main.detail.DetailActivity
import app.zhrfnnn.newsapp.ui.main.home.HomeActivity
import dagger.Subcomponent

/**
 * Created by Zharfan on 7/16/2023.
 */

@PerScreen
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(detailActivity: DetailActivity)
}