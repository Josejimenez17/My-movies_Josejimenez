package com.Jose.mymovi.model

import com.Jose.mymovi.model.MediaItem.*

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
        thumb = "https://picsum.photos/200/300?random=$it",
        type = if (it % 3 == 0) Type.VIDEO else Type.PHOTO
    )
}
