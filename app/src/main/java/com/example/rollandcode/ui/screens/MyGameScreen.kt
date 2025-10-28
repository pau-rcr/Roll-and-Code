package com.example.rollandcode.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rollandcode.data.UserGame

@Composable
fun MyGamesScreen(userName: String) {
    // Datos simulados: juegos adquiridos y arrendados con progreso
    val acquiredGames = listOf(
        UserGame("FIFA 25", "Deportes", "PS5", 48, "Desde hace 5 días"),
        UserGame("God of War", "Aventura", "PS5", 75, "Desde hace 2 semanas")
    )
    val rentedGames = listOf(
        UserGame("Animal Crossing", "Simulación", "Switch", 22, "Desde hace 3 días"),
        UserGame("NBA 2k26", "Deportes", "PS5", 10, "Desde hace 1 día")
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mis Juegos - $userName", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Adquiridos", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        LazyColumn {
            items(acquiredGames) { game ->
                GameProgressCard(game)
            }
        }
        Spacer(Modifier.height(16.dp))
        Text("Arrendados", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        LazyColumn {
            items(rentedGames) { game ->
                GameProgressCard(game)
            }
        }
    }
}

@Composable
fun GameProgressCard(game: UserGame) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(game.name, style = MaterialTheme.typography.titleLarge)
            Text(game.genre, style = MaterialTheme.typography.labelMedium)
            Text(game.platform, style = MaterialTheme.typography.labelSmall)
            Spacer(Modifier.height(8.dp))
            LinearProgressIndicator(progress = game.progress / 100f, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(4.dp))
            Text("${game.progress}% jugado")
            Text("Progreso: ${game.progressDescription}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
