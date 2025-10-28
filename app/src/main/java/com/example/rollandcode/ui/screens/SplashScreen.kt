package com.example.rollandcode.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)), // fondo oscuro
        contentAlignment = Alignment.Center
    ) {
        Text("GameZone", style = MaterialTheme.typography.headlineLarge, color = Color(0xFFFF6600))
        LaunchedEffect(true) {
            delay(2000L) // 2 segundos
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}
