package com.example.recipe_finder.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipe_finder.model.Meal
import com.example.recipe_finder.network.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {

    var query by remember { mutableStateOf("") }
    var meals by remember { mutableStateOf<List<Meal>>(emptyList()) }

    var expanded by remember { mutableStateOf(false) }
    var cuisine by remember { mutableStateOf("Indian") }

    var selectedMeal by remember { mutableStateOf<Meal?>(null) }

    val scope = rememberCoroutineScope()

    // 👉 Detail Screen
    if (selectedMeal != null) {

        DetailScreen(
            meal = selectedMeal!!,
            onBack = { selectedMeal = null }
        )

    } else {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Recipe Finder 🍲",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search recipe") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box {

                Button(onClick = { expanded = true }) {
                    Text("Cuisine: $cuisine")
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    listOf(
                        "Indian",
                        "Chinese",
                        "Italian",
                        "Mexican",
                        "American"
                    ).forEach {

                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                cuisine = it
                                expanded = false
                            }
                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {

                    scope.launch {

                        val response =
                            RetrofitInstance.api.searchMeal(query)

                        meals = response.meals ?: emptyList()

                    }

                }
            ) {
                Text("Search")
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                items(meals) { meal ->

                    RecipeCard(meal) {

                        selectedMeal = meal

                    }

                }

            }

        }

    }

}