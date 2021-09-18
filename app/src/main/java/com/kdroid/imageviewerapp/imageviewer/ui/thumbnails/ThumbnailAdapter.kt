package com.kdroid.imageviewerapp.imageviewer.ui.thumbnails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kdroid.imageviewerapp.R
import com.kdroid.imageviewerapp.databinding.RecyclercellRowBinding
import com.kdroid.imageviewerapp.databinding.RowDummyBinding
import com.kdroid.imageviewerapp.imageviewer.data.model.ImageResponse

class ThumbnailAdapter(context: Context, screenWidth: Int,list: ArrayList<ImageResponse>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val context: Context = context
    var list: ArrayList<ImageResponse> = list
    private var cellSize: Int = context.resources.getDimension(R.dimen.cell_height).toInt()


    companion object {
        const val TYPE_CELL: Int = 1
        const val TYPE_DUMMY: Int = 0
    }

    private inner class View1ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = RowDummyBinding.bind(itemView);
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
//            message.text = recyclerViewModel.textData
        }
    }

    private inner class View2ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclercellRowBinding.bind(itemView);
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
//            message.text = recyclerViewModel.textData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_CELL) {
            return View1ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.recyclercell_row, parent, false)
            )
        }
        return View2ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_dummy, parent, false)
        )
    }


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == TYPE_CELL) {
            (holder as View1ViewHolder).bind(position)
        } else {
            (holder as View2ViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_DUMMY
        } else {
            TYPE_CELL
        }
    }

    fun setCurrentActivrPosition(indicatorPosition: Int) {
        mIndicatorPosition = indicatorPosition
    }

    fun getCurrentIndicatorPosition(): Int {
        return mIndicatorPosition
    }

    protected var mIndicatorPosition = 0

}