package com.rahulrajbarnwal.newsapp.api

import com.rahulrajbarnwal.newsapp.repo.NewsRepository
import com.rahulrajbarnwal.newsapp.viewModel.NewsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiHelper::class, AppModule::class, DBModule::class])
interface ApiComponent {

    val newsApi: NewsApi

    fun inject(repo: NewsRepository)
    fun inject(newsVM: NewsViewModel)
}