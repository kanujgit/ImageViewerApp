package com.kdroid.imageviewerapp.imageviewer.ui

import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kdroid.imageviewerapp.core.network.NetworkResponse
import com.kdroid.imageviewerapp.core.widget.StartSnapHelper
import com.kdroid.imageviewerapp.databinding.ActivityMainBinding
import com.kdroid.imageviewerapp.imageviewer.data.model.ImageResponse
import com.kdroid.imageviewerapp.imageviewer.data.repository.GalleryRepo
import com.kdroid.imageviewerapp.imageviewer.data.viewmodel.GalleryViewModel
import com.kdroid.imageviewerapp.imageviewer.ui.imageviewer.ImagerViewAdapter
import com.kdroid.imageviewerapp.imageviewer.ui.thumbnails.ThumbnailAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val TAG: String? = MainActivity::class.java.canonicalName

    private val galleryViewModel: GalleryViewModel by viewModels()

    private val snapHelperStart: StartSnapHelper = StartSnapHelper()
    private lateinit var adaptor: ThumbnailAdapter
    private var list = ArrayList<ImageResponse>()


    companion object {
        const val CELL_VISIBLITY = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val repo = GalleryRepo()
        galleryViewModel.setRepo(repo)


        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            recycledViewPool.setMaxRecycledViews(0, 12)
            setItemViewCacheSize(1)
        }


        adaptor = ThumbnailAdapter(
            context = applicationContext,
            screenWidth = window.windowManager.defaultDisplay.width,
            list = list
        )
        binding.pager.adapter = ImagerViewAdapter(fm = supportFragmentManager)


        /*Snap helper help you snap the selected item to the Start*/
        snapHelperStart.attachToRecyclerView(binding.recyclerView)

        /*Making the indicator layout same as the width of one cell*/
        val params = RelativeLayout.LayoutParams(
            window.windowManager.defaultDisplay.width / CELL_VISIBLITY,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        binding.pickerIndicatorLayout.layoutParams = params



        galleryViewModel.fetchImages().observe(this, {
            when (it) {
                is NetworkResponse.Success ->
                    list = it.body
                is NetworkResponse.ApiError ->{

                }
                is NetworkResponse.UnknownError ->
                    Log.d(TAG, it.toString())
                is NetworkResponse.NetworkError ->
                    Log.d(TAG, it.toString())
            }
        })
    }


    protected fun updateCurrentPosition(position: Int, dx: Float, positionOffset: Float) {
        if (adaptor == null) {
            return
        }
        var activePosition = -1
        if (dx > 0 && positionOffset >= 0.59900004) {
            activePosition = position + 1
        } else if (dx < 0 && positionOffset <= 0.40099996) {
            activePosition = position
        }
        if (activePosition >= 0 && activePosition != adaptor.getCurrentIndicatorPosition()) {
            adaptor.setCurrentActivrPosition(activePosition)
            adaptor.notifyDataSetChanged()
        }
    }

}