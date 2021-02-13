package com.rahulrajbarnwal.newsapp.ui

import android.os.Bundle
import android.util.Log
import com.rahulrajbarnwal.newsapp.databinding.ActivityDetailBinding
import com.rahulrajbarnwal.newsapp.model.NewsData

class DetailActivity : BasicActivity<ActivityDetailBinding>() {

    override val layoutResourceId: Int
        get() = com.rahulrajbarnwal.newsapp.R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarText("News Detail")
        hideProgress()
        showData()

        val bundle: Bundle? = intent.extras
        bundle?.let {
            bundle.apply {
                val data = getSerializable("data") as NewsData
                Log.e("data12", data.author +" - " + data.source)

                binding.setVariable(1, data)
                binding.executePendingBindings()

                binding.tvDesc.setText(data.description)
                binding.tvContent.setText(data.content)
                binding.tvHead.setText(data.title)
                binding.tvSource.setText(data.source.name)

            }
        }

    }

}