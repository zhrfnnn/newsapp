package app.zhrfnnn.newsapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.zhrfnnn.newsapp.App
import app.zhrfnnn.newsapp.di.module.ScreenModule

/**
 * Created by Zharfan on 7/16/2023.
 */

abstract class BaseActivity : AppCompatActivity() {

    val screenComponent by lazy {
        (application as App).component.plus(ScreenModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        observe()
    }

    abstract fun setup()
    abstract fun observe()
}