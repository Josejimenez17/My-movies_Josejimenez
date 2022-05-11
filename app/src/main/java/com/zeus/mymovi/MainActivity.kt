package com.zeus.mymovi

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.zeus.mymovi.ui.theme.MyMoviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background)
                 {
                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MediaItem(){
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(color = Color.Red)
        ){

        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ){
            Text(
                text = "Title 1",
                style = MaterialTheme.typography.h6)

        }


    }
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


@Composable
fun DefaultPreview() {
    MyMoviTheme {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Greeting("Zeus", modifier = Modifier.background(Color.LightGray))
            Greeting("Android", modifier = Modifier.background(Color.Yellow))
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