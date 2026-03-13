package com.example.recipe_finder.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.recipe_finder.model.Meal

@Composable
fun DetailScreen(
    meal: Meal,
    onBack: () -> Unit
) {

    // system back button handle
    BackHandler {
        onBack()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Button(
            onClick = { onBack() }
        ) {
            Text("⬅ Back")
        }

        Spacer(modifier = Modifier.height(12.dp))

        AsyncImage(
            model = meal.strMealThumb,
            contentDescription = meal.strMeal,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = meal.strMeal,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Cooking Directions 🍳",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = meal.strInstructions,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(40.dp))
    }
}