package com.example.rollandcode.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(userName: String, navController: NavController) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true, onClick = { /*TODO*/ },
                    label = { Text("Juegos") }, icon = { Icon(Icons.Default.Home, null) }
                )
                NavigationBarItem(
                    selected = true, onClick = { /*TODO*/ },
                    label = { Text("Juegos") }, icon = { Icon(Icons.Default.PlayArrow, null) }
                )
                NavigationBarItem(
                    selected = false, onClick = { /*TODO*/ },
                    label = { Text("Mi perfil") }, icon = { Icon(Icons.Default.Person, null) }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Bienvenido, $userName", style = MaterialTheme.typography.headlineLarge)
            Spacer(Modifier.height(32.dp))
            Text("Aquí irán las recomendaciones, juegos destacados o noticias de Gamezone.",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}
