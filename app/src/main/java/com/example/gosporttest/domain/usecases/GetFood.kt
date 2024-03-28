package com.example.gosporttest.domain.usecases

import com.example.gosporttest.data.models.Meal
import com.example.gosporttest.domain.repository.FoodRepository

class GetFood(
    private val foodRepository: FoodRepository
) {
    suspend fun execute(): List<Meal>{
        return foodRepository.getFood()
    }
}