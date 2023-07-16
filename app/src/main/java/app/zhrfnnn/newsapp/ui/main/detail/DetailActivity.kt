package app.zhrfnnn.newsapp.ui.main.detail

import android.annotation.SuppressLint
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import app.zhrfnnn.newsapp.R
import app.zhrfnnn.newsapp.databinding.ActivityDetailBinding
import app.zhrfnnn.newsapp.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by Zharfan on 7/16/2023.
 */

class DetailActivity : BaseActivity(){

    companion object {
        private var url : String? = null

        fun instance(url: String) : DetailActivity {
            Companion.url = url
            return DetailActivity()
        }
    }

    @Inject lateinit var vm : DetailVM
    private lateinit var binding : ActivityDetailBinding

    override fun setup() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        screenComponent.inject(this)
        binding.vm = vm
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun observe() {
        binding.webviewDetail.webViewClient = WebViewClient()
        binding.webviewDetail.settings.domStorageEnabled = true
        binding.webviewDetail.settings.javaScriptEnabled = true
        url?.also {
            binding.webviewDetail.loadUrl(it)
        }
    }
}