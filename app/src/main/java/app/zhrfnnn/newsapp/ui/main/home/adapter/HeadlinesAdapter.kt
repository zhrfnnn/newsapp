package app.zhrfnnn.newsapp.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import app.zhrfnnn.newsapp.BR
import app.zhrfnnn.newsapp.R
import app.zhrfnnn.newsapp.data.model.Article
import app.zhrfnnn.newsapp.util.log

/**
 * Created by Zharfan on 7/16/2023.
 */

class HeadlinesAdapter(private val articles : List<Article>,
                       private val adapterOnClick: (Article?, position: Int) -> Unit) : RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>() {

    inner class HeadlinesViewHolder(private val binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(article: Article, position: Int){
            binding.setVariable(BR.article,article)
            binding.root.setOnClickListener {
                adapterOnClick(article,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        return HeadlinesViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_article,parent,false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        holder.bind(articles[position],position)
    }
}