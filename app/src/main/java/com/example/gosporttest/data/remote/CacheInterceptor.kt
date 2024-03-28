package com.example.gosporttest.data.remote

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val cacheControl = CacheControl.Builder()
            .maxAge(180, TimeUnit.SECONDS)
            .build()
        val newRequest = request.newBuilder()
            .cacheControl(cacheControl)
            .build()
        return chain.proceed(newRequest)
    }
}