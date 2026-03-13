package com.example.recipe_finder.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipe_finder.model.Meal
import com.example.recipe_finder.favorite.FavoriteManager

@Composable
fun RecipeCard(
    meal: Meal,
    onClick: () -> Unit
) {

    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onClick() },   // 👈 यह जरूरी है
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Column {

            AsyncImage(
                model = meal.strMealThumb,
                contentDescription = meal.strMeal,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = meal.strMeal,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(10.dp)
            )

            Button(
                onClick = {

                    isFavorite = !isFavorite

                    if (isFavorite) {
                        FavoriteManager.addFavorite(meal)
                    }

                },
                modifier = Modifier.padding(10.dp)
            ) {

                if (isFavorite)
                    Text("❤️ Favorited")
                else
                    Text("Add to Favorite")

            }

        }

    }

}