package com.zeus.mymovi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.zeus.mymovi.MediaItem.*
import com.zeus.mymovi.ui.theme.MyMoviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    StateSamble()
                }
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable
fun StateSamble() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
           text = text ,
            modifier = Modifier.fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { text = "" },
            modifier = Modifier.fillMaxWidth(),
            enabled = text.isNotEmpty()
        ) {
            Text(text = "Clear")
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@ExperimentalCoilApi
//@Preview
@Composable
fun MediaList() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(150.dp)
    ){
        items(getMedia()) { item ->
            MediaListItem(item, Modifier.padding(2.dp))
        }
    }
}


@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ){
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
        ){

            Image(
                painter = rememberAsyncImagePainter(
                    model = "http://pics.filmaffinity.com/El_caballero_oscuro-102763119-large.jpg"
                ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
            )
            if(item.type == Type.VIDEO) {

                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier
                        .size(92.dp)
                        .align(Alignment.Center),

                    tint = Color.White
                )
            }


        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ){
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6)

        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World",
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(10f, 10f),
                    blurRadius = 5f,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            ),

           /* lineHeight = 2.em,
            maxLines = 1,
            softWrap = false,*/


        )
    }
}
