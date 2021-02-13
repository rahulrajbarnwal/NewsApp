package com.rahulrajbarnwal.newsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahulrajbarnwal.newsapp.model.BaseModel
import com.rahulrajbarnwal.newsapp.model.NewsData
import com.rahulrajbarnwal.newsapp.repo.NewsRepository
import com.rahulrajbarnwal.newsapp.utils.Appcontroller
import javax.inject.Inject

class NewsViewModel : ViewModel() {

    var newsLiveData: MutableLiveData<BaseModel<ArrayList<NewsData>>>

    init {
        this.newsLiveData = MutableLiveData()
        Appcontroller.app.mApiComponent.inject(this)
    }

    @Inject
    lateinit var mRepository: NewsRepository

    fun getNewsList(): MutableLiveData<BaseModel<ArrayList<NewsData>>> {
        newsLiveData = mRepository.fetchNewsList()
        return newsLiveData
    }
}