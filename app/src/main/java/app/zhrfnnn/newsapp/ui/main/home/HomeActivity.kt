package app.zhrfnnn.newsapp.ui.main.home

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import app.zhrfnnn.newsapp.R
import app.zhrfnnn.newsapp.databinding.ActivityHomeBinding
import app.zhrfnnn.newsapp.ui.base.BaseActivity
import app.zhrfnnn.newsapp.ui.main.detail.DetailActivity
import app.zhrfnnn.newsapp.ui.main.home.adapter.HeadlinesAdapter
import app.zhrfnnn.newsapp.util.goToActivity
import javax.inject.Inject

/**
 * Created by Zharfan on 7/16/2023.
 */

class HomeActivity : BaseActivity(){
    
    @Inject lateinit var vm : HomeVM
    private lateinit var binding : ActivityHomeBinding
    
    override fun setup() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        screenComponent.inject(this)
        binding.vm = vm
    }

    override fun observe() {
        setupRecycler()
        vm.articlesData.observe(this){
            vm.articles.clear()
            vm.articles.addAll(it)
            binding.recyclerHome.adapter?.notifyDataSetChanged()
            binding.swipelayoutHome.isRefreshing = false
        }
        binding.swipelayoutHome.setOnRefreshListener {
            refresh()
        }
        refresh()
    }

    private fun refresh(){
        binding.swipelayoutHome.isRefreshing = true
        vm.getHeadlines()
    }

    private fun setupRecycler(){
        binding.recyclerHome.layoutManager = LinearLayoutManager(this)
        binding.recyclerHome.adapter = HeadlinesAdapter(vm.articles){ article,_ ->
            article?.url?.also { url ->
                goToActivity(DetailActivity.instance(url))
            }
        }
    }
}