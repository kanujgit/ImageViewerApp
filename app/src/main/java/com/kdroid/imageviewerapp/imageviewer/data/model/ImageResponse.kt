package com.kdroid.imageviewerapp.imageviewer.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("urls")
    var urls: UrlsEntity,
)

data class UrlsEntity(
    @Expose
    @SerializedName("raw")
    val raw: String,
    @Expose
    @SerializedName("full")
    val full: String,
    @Expose
    @SerializedName("regular")
    val regular: String,
    @Expose
    @SerializedName("small")
    val small: String,
    @Expose
    @SerializedName("thumb")
    val thumb: String
)
