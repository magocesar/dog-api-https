package com.example.dog_api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomDogFactApiService {
    private const val BASE_URL = "http://dog-api.kinduff.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(RandomDogFactInterface::class.java)
}