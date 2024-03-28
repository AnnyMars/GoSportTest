package com.example.gosporttest.domain.repository

import com.example.gosporttest.data.models.Category
import com.example.gosporttest.data.models.Meal

interface FoodRepository {
    suspend fun getFood(): List<Meal>
    suspend fun getCategory(): List<Category>
}