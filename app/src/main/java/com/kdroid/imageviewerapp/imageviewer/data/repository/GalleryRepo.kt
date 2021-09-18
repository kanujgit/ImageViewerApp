package com.kdroid.imageviewerapp.imageviewer.data.repository

import com.kdroid.imageviewerapp.core.network.ApiClient
import com.kdroid.imageviewerapp.core.network.NetworkResponse
import com.kdroid.imageviewerapp.imageviewer.data.model.Error
import com.kdroid.imageviewerapp.imageviewer.data.model.ImageResponse

class GalleryRepo {
    suspend fun getImages(): NetworkResponse<ArrayList<ImageResponse>, Error> = ApiClient.request!!.getImages()
}