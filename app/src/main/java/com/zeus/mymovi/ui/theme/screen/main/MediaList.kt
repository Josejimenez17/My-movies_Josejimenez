package com.zeus.mymovi.ui.theme.screen.main

import android.icu.text.CaseMap
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.zeus.mymovi.model.MediaItem
import com.zeus.mymovi.model.getMedia


@OptIn(ExperimentalFoundationApi::class)
@ExperimentalCoilApi
@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(150.dp),
        modifier = modifier
    ){
        items(getMedia()) { item ->
            MediaListItem(
                item,
                navController,
                Modifier.padding(4.dp))
        }
    }
}


@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaListItem(
    mediaitem: MediaItem,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { navController.navigate("detail/${mediaitem.id}") },
             elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Thumb(mediaitem)
            Title(mediaitem)
        }
    }

}

@Composable
private fun Title(mediaitem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(16.dp)
    ) {
        Text(
            text = mediaitem.title,
            style = MaterialTheme.typography.h6
        )
    }
}


@OptIn(ExperimentalCoilApi::class)
@ExperimentalFoundationApi
@Preview
@Composable
fun MediaListPreview() {
    //val mediaItem = MediaItem(1, "The Bad Man 1", "", MediaItem.Type.VIDEOMediaItem.Type.PHOTO)
}