package com.kdroid.imageviewerapp.imageviewer.ui.imageviewer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ImagerViewAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 5
    override fun getItem(position: Int): Fragment {
        return ImageViewerFragment.newInstance(position)
    }

}
