package com.kdroid.imageviewerapp

import android.app.Application
import com.kdroid.imageviewerapp.core.network.ApiClient

class ImageViewerApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        ApiClient.init()
    }
}