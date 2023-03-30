package com.example.music_nr.data

data class HomeItem<T>(
    val item: T,
    val type: HomeType,
)

enum class HomeType {
    ITEM_SEARCH,
    ITEM_TRENDING_RECYCLER_VIEW,
    ITEM_CHIPS,
    ITEM_MUSIC_CARD,
}