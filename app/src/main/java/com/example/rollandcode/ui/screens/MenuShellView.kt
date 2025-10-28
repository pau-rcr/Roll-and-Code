package com.example.rollandcode.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.rollandcode.data.Game
import com.example.rollandcode.ui.screens.GamesScreen
import com.example.rollandcode.ui.screens.MyGamesScreen
import com.example.rollandcode.ui.screens.ProfileScreen

@Composable
fun MenuShellView(userName: String, userEmail: String, navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Juegos") },
                    label = { androidx.compose.material3.Text("Juegos") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Mis Juegos") },
                    label = { androidx.compose.material3.Text("Mis Juegos") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { androidx.compose.material3.Text("Perfil") }
                )
            }
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> GamesScreen(navController)                 // <-- navController como primer argumento
                1 -> MyGamesScreen(userName)                    // <-- userName aquí está bien
                2 -> ProfileScreen(userName, userEmail)         // <-- ambos Strings
            }
        }
    }
}