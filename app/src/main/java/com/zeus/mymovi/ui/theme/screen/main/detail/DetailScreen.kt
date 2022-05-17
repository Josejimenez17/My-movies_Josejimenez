package com.zeus.mymovi.ui.theme.screen.main.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.zeus.mymovi.model.getMedia
import com.zeus.mymovi.ui.theme.screen.main.Thumb

@Composable
fun DetailScreen(mediaId: Int) {
    val mediaItem = remember {getMedia().first {it.id == mediaId }}
    
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = mediaItem.title) }) }
    ){ padding ->
    Thumb(mediaitem = mediaItem, Modifier.padding(padding))
    }
}