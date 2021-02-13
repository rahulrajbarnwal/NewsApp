package com.rahulrajbarnwal.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahulrajbarnwal.newsapp.R
import com.rahulrajbarnwal.newsapp.adapter.NewsListAdapter
import com.rahulrajbarnwal.newsapp.databinding.ActivityBasicBinding
import com.rahulrajbarnwal.newsapp.databinding.ActivityMainBinding
import com.rahulrajbarnwal.newsapp.model.NewsData
import com.rahulrajbarnwal.newsapp.viewModel.NewsViewModel

class MainActivity : BasicActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int
        get() = com.rahulrajbarnwal.newsapp.R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarText("Top News")
        hideBack()
        getNewsApi()
    }

    private fun getNewsApi() {
        val newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        newsViewModel.getNewsList().observe(this, Observer { newsData ->
            hideProgress()
            showData()
            setAdapter(newsData.articles);
        })
    }

    private fun setAdapter(newsList: ArrayList<NewsData>) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = NewsListAdapter(this@MainActivity, newsList)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )

            (adapter as NewsListAdapter).onItemClick = {
                    url ->

            }

        }
    }

}