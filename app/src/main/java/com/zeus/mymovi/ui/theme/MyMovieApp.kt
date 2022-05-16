package com.zeus.mymovi.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

@Composable
public fun MyMovieApp(function: @Composable () -> Unit) {
    MyMoviTheme() {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            function()
        }
    }
}