package com.example.music_nr.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music_nr.R
import com.example.music_nr.databinding.ItemTrendingRightNowCardBinding
import com.example.music_nr.util.loadImage

class TrendingAdapter(private val imgUrls: List<String>) :
    RecyclerView.Adapter<TrendingAdapter.TrendingRecycleHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRecycleHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trending_right_now_card, parent, false)
        return TrendingRecycleHolder(view)
    }

    override fun getItemCount() = imgUrls.size

    override fun onBindViewHolder(holder: TrendingRecycleHolder, position: Int) {
        val imgUrl = imgUrls[position]
        holder.binding.imageBigCard.loadImage(imgUrl)
    }

    class TrendingRecycleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemTrendingRightNowCardBinding.bind(itemView)
    }
}