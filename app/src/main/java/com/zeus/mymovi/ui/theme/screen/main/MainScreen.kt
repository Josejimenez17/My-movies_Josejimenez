package com.zeus.mymovi.ui.theme.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi


@OptIn(ExperimentalCoilApi::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        MediaList(navController, Modifier.padding(padding))
    }
}