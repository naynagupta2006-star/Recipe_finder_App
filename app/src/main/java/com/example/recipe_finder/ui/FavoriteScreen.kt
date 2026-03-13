package com.example.recipe_finder.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipe_finder.favorite.FavoriteManager

@Composable
fun FavoriteScreen() {

    val favorites = FavoriteManager.favoriteMeals

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Favorite Recipes ❤️",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(favorites) { meal ->

                RecipeCard(meal) { }

            }

        }

    }

}