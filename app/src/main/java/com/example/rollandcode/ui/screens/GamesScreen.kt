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
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.rollandcode.R
import com.example.rollandcode.data.Game

@Composable
fun GamesScreen(navController: NavController) {
    val games = listOf(
        Game(
            1,
            "FIFA 25",
            "Deportes",
            "PS5",
            R.drawable.fifa25,
            40000,
            "El simulador clásico de fútbol con licencias oficiales, nuevos modos y una experiencia realista mejorada."
        ),
        Game(
            2,
            "Animal Crossing",
            "Simulación",
            "Nintendo Switch",
            R.drawable.animalcrossing,
            35000,
            "Construye tu isla ideal y vive una vida tranquila junto a carismáticos vecinos animales. Personaliza, explora y comparte tu mundo."
        ),
        Game(
            3,
            "God of War",
            "Aventura",
            "PS5",
            R.drawable.godofwar,
            25000,
            "Kratos regresa con combates épicos, exploración y una historia profunda en los mundos nórdicos junto a su hijo Atreus."
        ),
        Game(
            4,
            "Assasin's Creed",
            "Aventura",
            "PS5",
            R.drawable.assasinscreed,
            32990,
            "Sumérgete en la historia y recorre ciudades históricas mientras sigues el camino de los Assasins en esta saga de mundo abierto."
        ),
        Game(
            5,
            "The Legend of Zelda: Tears of the Kingdom",
            "Aventura",
            "Nintendo Switch",
            R.drawable.thelegendofzeldatears,
            54990,
            "Una nueva epopeya para Link. Explora Hyrule, descubre secretos ancestrales y domina nuevas habilidades en esta saga legendaria."
        ),
        Game(
            6,
            "NBA 2k26",
            "Deportes",
            "PS5",
            R.drawable.nba2k26,
            24990,
            "Toda la emoción del baloncesto profesional con equipos actualizados, modos de juego variados y simulación avanzada."
        ),
        Game(
            7,
            "Halo",
            "Shooter",
            "Xbox",
            R.drawable.halo,
            39990,
            "Combate futurista y acción intensa contra las fuerzas alienígenas en la saga icónica del Jefe Maestro."
        ),
        Game(
            8,
            "Hollow Knight",
            "Plataforma",
            "PS5",
            R.drawable.hollowknight,
            46990,
            "Explora profundos laberintos, enfrenta peligros y desentraña los misterios del reino subterráneo de Hallownest."
        )
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
                        Row(
                            Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = game.imageRes),
                                contentDescription = game.name,
                                modifier = Modifier.size(64.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(game.name, style = MaterialTheme.typography.titleLarge)
                                Text(game.genre, style = MaterialTheme.typography.labelMedium)
                                Text(game.platform, style = MaterialTheme.typography.labelSmall)
                                Text("Precio: $${game.price}", style = MaterialTheme.typography.labelSmall)

                            }
                        }
                    }
                }
            }
        } else {
            GameDetailScreen(game = selectedGame!!) {
                selectedGame = null
            }
        }
    }
}

@Composable
fun GameDetailScreen(game: Game, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = game.imageRes),
            contentDescription = game.name,
            modifier = Modifier
                .size(250.dp) // tamaño grande
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )
        Text(game.name, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Categoría: ${game.genre}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(10.dp))
        Text("Plataforma: ${game.platform}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(10.dp))
        Text("Precio: $${game.price}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(24.dp))
        Text(game.description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(24.dp))
        androidx.compose.material3.Button(onClick = { onBack() }) {
            Text("Volver")
        }
    }
}
