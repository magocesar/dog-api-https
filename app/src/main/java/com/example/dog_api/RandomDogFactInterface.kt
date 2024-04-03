package com.example.dog_api

import retrofit2.Response
import retrofit2.http.GET

interface RandomDogFactInterface {
    @GET("facts")
    suspend fun getDogFact() : Response<RandomDogFact>
}