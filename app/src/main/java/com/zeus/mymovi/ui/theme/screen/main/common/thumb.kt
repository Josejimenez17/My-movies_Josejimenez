package com.zeus.mymovi.ui.theme.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.zeus.mymovi.model.MediaItem

@ExperimentalCoilApi
@Composable
fun Thumb(mediaitem: MediaItem, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(
                data = mediaitem.thumb
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (mediaitem.type == MediaItem.Type.VIDEO) {
            Icon(
                Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier
                    .size(92.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}