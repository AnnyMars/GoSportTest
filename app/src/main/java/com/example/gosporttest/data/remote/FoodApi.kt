package com.example.gosporttest.data.remote

import com.example.gosporttest.data.models.CategoryModel
import com.example.gosporttest.data.models.FoodModel
import retrofit2.http.GET

interface FoodApi {
    @GET("search.php?s")
    suspend fun getFoodList(): FoodModel

    @GET("categories.php")
    suspend fun getCategoryList(): CategoryModel
}