package com.kdroid.imageviewerapp.imageviewer.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Error(
    @Expose
    @SerializedName("errors")
    val Errors: List<String>
)