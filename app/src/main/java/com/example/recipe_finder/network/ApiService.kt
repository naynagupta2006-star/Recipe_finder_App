package com.example.recipe_finder.network

import com.example.recipe_finder.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    suspend fun searchMeal(
        @Query("s") query: String
    ): MealResponse

}