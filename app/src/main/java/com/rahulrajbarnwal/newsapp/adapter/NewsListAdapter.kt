package com.rahulrajbarnwal.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulrajbarnwal.newsapp.R
import com.rahulrajbarnwal.newsapp.databinding.ItemNewsBinding
import com.rahulrajbarnwal.newsapp.model.NewsData

class NewsListAdapter(var context: Context, var newsList: ArrayList<NewsData>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    lateinit var onItemClick: ((NewsData) -> Unit?)

    class ViewHolder (val binding: ItemNewsBinding, val onItemClick: (NewsData) -> Unit?) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(1, data)
            binding.executePendingBindings()

            binding.clRoot.setOnClickListener {
                onItemClick.invoke(data as NewsData)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_news, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList.get(position))
    }

    override fun getItemCount(): Int = newsList.size

}
