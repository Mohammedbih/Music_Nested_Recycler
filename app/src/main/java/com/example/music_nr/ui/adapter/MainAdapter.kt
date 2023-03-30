package com.example.music_nr.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music_nr.R
import com.example.music_nr.data.HomeItem
import com.example.music_nr.data.HomeType
import com.example.music_nr.data.Music
import com.example.music_nr.databinding.ItemChipsBinding
import com.example.music_nr.databinding.ItemMusicCardBinding
import com.example.music_nr.databinding.ItemSearchBinding
import com.example.music_nr.databinding.TrendingRightNowRvBinding
import com.example.music_nr.util.loadImage

class MainAdapter(private val items: List<HomeItem<Any>>) :
    RecyclerView.Adapter<MainAdapter.BaseHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return when (viewType) {
            VIEW_TYPE_SEARCH -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_search, parent, false)
                SearchHolder(view)
            }
            VIEW_TYPE_TRENDING_RECYCLER_VIEW -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.trending_right_now_rv, parent, false)
                TrendingHolder(view)
            }
            VIEW_TYPE_CHIPS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chips, parent, false)
                ChipsHolder(view)
            }
            VIEW_TYPE_MUSIC_CARD -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_music_card, parent, false)
                MusicCardHolder(view)
            }
            else -> throw Exception("Unknown View Type")
        }
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        when (holder) {
            is SearchHolder -> bindSearchHolder(holder, position)
            is TrendingHolder -> bindTrendingHolder(holder, position)
            is ChipsHolder -> bindChipsHolder(holder, position)
            is MusicCardHolder -> bindMusicCardHolder(holder, position)
        }
    }

    private fun bindSearchHolder(holder: SearchHolder, position: Int) {
        val hint = items[position].item as String
        holder.binding.editTextName.hint = hint
    }

    private fun bindTrendingHolder(holder: TrendingHolder, position: Int) {
        val imgUrls = items[position].item as List<String>
        val adapter = TrendingAdapter(imgUrls)
        holder.binding.recyclerViewTrending.adapter = adapter
    }

    private fun bindChipsHolder(holder: ChipsHolder, position: Int) {

    }

    private fun bindMusicCardHolder(holder: MusicCardHolder, position: Int) {
        val music = items[position].item as Music
        with(holder.binding) {
            textSongName.text = music.title
            textSongWriter.text = music.songWriters
            imageMusic.loadImage(music.image)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            HomeType.ITEM_SEARCH -> VIEW_TYPE_SEARCH
            HomeType.ITEM_TRENDING_RECYCLER_VIEW -> VIEW_TYPE_TRENDING_RECYCLER_VIEW
            HomeType.ITEM_CHIPS -> VIEW_TYPE_CHIPS
            HomeType.ITEM_MUSIC_CARD -> VIEW_TYPE_MUSIC_CARD
        }
    }

    override fun getItemCount() = items.size

    abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class SearchHolder(itemView: View) : BaseHolder(itemView) {
        val binding: ItemSearchBinding = ItemSearchBinding.bind(itemView)
    }

    class TrendingHolder(itemView: View) : BaseHolder(itemView) {
        val binding: TrendingRightNowRvBinding = TrendingRightNowRvBinding.bind(itemView)
    }

    class ChipsHolder(itemView: View) : BaseHolder(itemView) {
        val binding: ItemChipsBinding = ItemChipsBinding.bind(itemView)
    }

    class MusicCardHolder(itemView: View) : BaseHolder(itemView) {
        val binding: ItemMusicCardBinding = ItemMusicCardBinding.bind(itemView)
    }

    companion object {
        const val VIEW_TYPE_SEARCH = 0
        const val VIEW_TYPE_TRENDING_RECYCLER_VIEW = 1
        const val VIEW_TYPE_CHIPS = 2
        const val VIEW_TYPE_MUSIC_CARD = 3
    }
}