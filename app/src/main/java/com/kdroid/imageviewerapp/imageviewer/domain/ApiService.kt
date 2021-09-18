package com.kdroid.imageviewerapp.imageviewer.domain

import com.kdroid.imageviewerapp.core.network.NetworkResponse
import com.kdroid.imageviewerapp.imageviewer.data.model.Error
import com.kdroid.imageviewerapp.imageviewer.data.model.ImageResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/photos/?client_id=38b4f660e017edb7dadc5ce864869daf68441fd58249d0f773123334f11ef9f")
    suspend fun getImages(): NetworkResponse<ArrayList<ImageResponse>,Error>
}