package com.kdroid.imageviewerapp.imageviewer.data.viewmodel

import androidx.lifecycle.liveData
import com.flatworld.newsapp.core.ui.base.BaseViewModel
import com.kdroid.imageviewerapp.imageviewer.data.repository.GalleryRepo
import kotlinx.coroutines.Dispatchers

class GalleryViewModel : BaseViewModel<GalleryRepo>() {

    fun fetchImages() = liveData(Dispatchers.IO) {
        emit(getRepo()?.getImages())
    }


}