package com.example.rollandcode.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import com.example.rollandcode.data.Game

@Composable
fun GamesScreen(navController: NavController) {
    val games = listOf(
        Game(1, "FIFA 25", "Deportes", "PS5"),
        Game(2, "Animal Crossing", "Simulación", "Nintendo Switch"),
        Game(3, "God of War", "Aventura", "PS5"),
        Game(4, "Assasin's Creed", "Aventura", "PS5"),
        Game(5, "The Legend of Zelda: Tears of the Kingdom", "Aventura", "Nintendo Switch"),
        Game(6, "NBA 2k26", "Deportes", "PS5"),
        Game(7, "Halo", "Shooter", "Xbox"),
        Game(8, "Hollow Knight", "Plataforma", "PS5")
    )
    var selectedGame by remember { mutableStateOf<Game?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (selectedGame == null) {
            LazyColumn {
                items(games) { game ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { selectedGame = game },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(game.name, style = MaterialTheme.typography.titleLarge)
                            Text(game.genre, style = MaterialTheme.typography.labelMedium)
                            Text(game.platform, style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        } else {
            // selectedGame ES un Game?, pero no nulo en esta rama (ya está validado)
            GameDetailScreen(game = selectedGame!!) {
                selectedGame = null
            }
        }
    }
}

@Composable
fun GameDetailScreen(game: Game, onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(game.name, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Categoría: ${game.genre}", style = MaterialTheme.typography.bodyLarge)
        Text("Plataforma: ${game.platform}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(24.dp))
        androidx.compose.material3.Button(onClick = { onBack() }) {
            Text("Volver")
        }
    }
}