package com.kdroid.imageviewerapp.imageviewer.ui.imageviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.kdroid.imageviewerapp.R
import com.kdroid.imageviewerapp.databinding.FragmentImageViewerBinding

class ImageViewerFragment : Fragment() {

    private lateinit var binding: FragmentImageViewerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentImageViewerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param: Int) =
            ImageViewerFragment().apply {
                arguments = Bundle().apply {
                    putInt("position", param)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.image.load("") {
            placeholder(R.mipmap.ic_launcher)
            error(R.mipmap.ic_launcher)
        }
    }

}