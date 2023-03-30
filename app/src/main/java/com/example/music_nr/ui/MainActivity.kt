package com.example.music_nr.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.music_nr.data.DataManger
import com.example.music_nr.data.HomeItem
import com.example.music_nr.data.HomeType
import com.example.music_nr.databinding.ActivityMainBinding
import com.example.music_nr.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupMainViewRecyclerView()
    }

    private fun setupMainViewRecyclerView() {
        val items = mutableListOf<HomeItem<Any>>()
        items.add(HomeItem("Search About Song", HomeType.ITEM_SEARCH))
        items.add(HomeItem(DataManger.songs.map { it.image }, HomeType.ITEM_TRENDING_RECYCLER_VIEW))
        items.add(HomeItem("", HomeType.ITEM_CHIPS))
        items.addAll(DataManger.songs.map { it.toHomeItem() })
        val adapter = MainAdapter(items)
        binding.recyclerMainActivity.adapter = adapter
    }
}