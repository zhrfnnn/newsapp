package app.zhrfnnn.newsapp.di.module

import app.zhrfnnn.newsapp.di.PerScreen
import app.zhrfnnn.newsapp.ui.base.BaseActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Zharfan on 7/16/2023.
 */

@Module
class ScreenModule(private val activity: BaseActivity) {

    @PerScreen
    @Provides
    fun providesActivity(): BaseActivity {
        return activity
    }
}