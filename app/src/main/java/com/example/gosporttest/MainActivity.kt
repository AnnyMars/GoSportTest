package com.example.gosporttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gosporttest.presentation.HomeScreen
import com.example.gosporttest.presentation.HomeViewModel
import com.example.gosporttest.ui.theme.GoSportTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GoSportTestTheme {
                val viewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}
