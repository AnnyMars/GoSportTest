package com.example.gosporttest.di

import com.example.gosporttest.Utils.BASE_URL
import com.example.gosporttest.data.remote.CacheInterceptor
import com.example.gosporttest.data.remote.FoodApi
import com.example.gosporttest.data.remote.FoodRepositoryImpl
import com.example.gosporttest.domain.repository.FoodRepository
import com.example.gosporttest.domain.usecases.FoodUseCases
import com.example.gosporttest.domain.usecases.GetCategory
import com.example.gosporttest.domain.usecases.GetFood
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(CacheInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): FoodApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FoodApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(
        foodApi: FoodApi
    ): FoodRepository {
        return FoodRepositoryImpl(foodApi)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        foodRepository: FoodRepository
    ): FoodUseCases {
        return FoodUseCases(
            getFood = GetFood(foodRepository),
            getCategory = GetCategory(foodRepository)
        )
    }

}