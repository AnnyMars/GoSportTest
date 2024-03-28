package com.example.gosporttest.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gosporttest.R
import com.example.gosporttest.presentation.common.AppTopBar
import com.example.gosporttest.presentation.common.Chip
import com.example.gosporttest.presentation.common.FoodCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val foodData = viewModel.foodList.collectAsState().value
    val categoryData = viewModel.categoryList.collectAsState().value
    var selectedTag by remember { mutableStateOf("") }
    val foodByTag = foodData.filter { it.strCategory == selectedTag }


    val listState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0

    LaunchedEffect(Unit) {
        viewModel.getFood()
        viewModel.getCategory()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(onBackClick = {})
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                LazyRow(
                    modifier = Modifier
                        .graphicsLayer {
                            scrolledY += listState.firstVisibleItemScrollOffset - previousOffset
                            translationY = scrolledY * 0.5f
                            previousOffset = listState.firstVisibleItemScrollOffset
                        }
                ) {
                    items(6) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "",
                            modifier = Modifier
                                .width(200.dp)
                                .padding(horizontal = 5.dp)
                        )
                    }
                }
            }
            stickyHeader {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 5.dp),
                    modifier = Modifier.background(Color.White)
                ) {
                    items(categoryData.size) {
                        categoryData.forEach {
                            Chip(title = it.strCategory, selected = selectedTag, onSelected = {
                                selectedTag = it
                            })
                        }
                    }
                }
            }
            if (selectedTag.isNotBlank()) {
                items(count = foodByTag.size) {
                    foodByTag.forEach {
                        FoodCard(meal = it)
                    }
                }
            }
        }
    }
}

