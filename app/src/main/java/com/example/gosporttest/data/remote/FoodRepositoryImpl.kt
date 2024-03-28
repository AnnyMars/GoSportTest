package com.example.gosporttest.data.remote

import com.example.gosporttest.data.models.Category
import com.example.gosporttest.data.models.Meal
import com.example.gosporttest.domain.repository.FoodRepository

class FoodRepositoryImpl(
    private val foodApi: FoodApi
): FoodRepository {
    override suspend fun getFood(): List<Meal> {
        return foodApi.getFoodList().meals
    }

    override suspend fun getCategory(): List<Category> {
        return foodApi.getCategoryList().categories
    }

}