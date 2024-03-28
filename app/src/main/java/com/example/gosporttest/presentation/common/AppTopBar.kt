package com.example.gosporttest.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Москва")},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}
