package com.example.music_nr.data

data class Music(
    val id: Int,
    val title: String,
    val songWriters: String,
    val image: String
) {
    fun toHomeItem() = HomeItem(this, HomeType.ITEM_MUSIC_CARD) as HomeItem<Any>

}