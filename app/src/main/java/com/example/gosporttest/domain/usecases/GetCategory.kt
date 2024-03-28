package com.example.gosporttest.domain.usecases

import com.example.gosporttest.data.models.Category
import com.example.gosporttest.domain.repository.FoodRepository

class GetCategory(
    private val foodRepository: FoodRepository
) {
    suspend fun execute(): List<Category>{
        return foodRepository.getCategory()
    }
}