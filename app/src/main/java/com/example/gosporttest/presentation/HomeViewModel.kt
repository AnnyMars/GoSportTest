package com.example.gosporttest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gosporttest.data.models.Category
import com.example.gosporttest.data.models.Meal
import com.example.gosporttest.domain.usecases.FoodUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodUseCase: FoodUseCases
) : ViewModel() {

    private val _foodList = MutableStateFlow<List<Meal>>(emptyList())
    val foodList: StateFlow<List<Meal>> get() = _foodList

    private val _categoryList = MutableStateFlow<List<Category>>(emptyList())
    val categoryList: StateFlow<List<Category>> get() = _categoryList

    fun getFood() {
        viewModelScope.launch(Dispatchers.IO) {
            _foodList.value = foodUseCase.getFood.execute()
        }
    }

    fun getCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            _categoryList.value = foodUseCase.getCategory.execute()
        }
    }
}