package com.example.recipe_finder.favorite

import androidx.compose.runtime.mutableStateListOf
import com.example.recipe_finder.model.Meal

object FavoriteManager {

    val favoriteMeals = mutableStateListOf<Meal>()

    fun addFavorite(meal: Meal) {

        if (!favoriteMeals.contains(meal)) {
            favoriteMeals.add(meal)
        }

    }

    fun removeFavorite(meal: Meal) {

        favoriteMeals.remove(meal)

    }

}