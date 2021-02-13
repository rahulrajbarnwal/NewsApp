package com.rahulrajbarnwal.newsapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utils{
    companion object{
        fun isNetworkAvailable(): Boolean {
            val connectivityManager = Appcontroller.app.getSystemService(Context.CONNECTIVITY_SERVICE)
            return if (connectivityManager is ConnectivityManager) {
                val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                networkInfo?.isConnected ?: false
            } else false
        }
    }

}