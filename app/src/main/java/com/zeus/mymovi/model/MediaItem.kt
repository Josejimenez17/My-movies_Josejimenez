package com.zeus.mymovi.model

import com.zeus.mymovi.model.MediaItem.*

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
) {
    enum class Type { PHOTO, VIDEO }
}

fun getMedia()  = (1..10).map {
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "http://pics.filmaffinity.com/El_caballero_oscuro-102763119-large.jpg",
        type = if (it % 3 == 0) Type.VIDEO else Type.PHOTO
    )
}
