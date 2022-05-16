package com.zeus.mymovi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zeus.mymovi.ui.theme.screen.main.MainScreen
import com.zeus.mymovi.ui.theme.MyMovieApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             MyMovieApp {
                 MainScreen()
             }
        }
    }
}

