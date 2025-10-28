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
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp

@Composable
fun BouncingDotsAnimation(
    dotColor: Color = Color(0xFFFF6600),
    dotSize: Dp = 16.dp,
    spaceBetween: Dp = 8.dp,
    travelDistance: Dp = 10.dp
) {
    val infiniteTransition = rememberInfiniteTransition(label = "dots")
    val delays = listOf(0, 100, 200)
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentWidth()
    ) {
        for (i in 0 until 3) {
            val scale by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 1.5f,
                animationSpec = infiniteRepeatable(
                    animation = tween(600, delayMillis = delays[i], easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "dot${i + 1}"
            )
            Surface(
                shape = CircleShape,
                color = dotColor,
                modifier = Modifier
                    .size(dotSize)
                    .scale(scale)
            ) {}
            if (i != 2) Spacer(Modifier.width(spaceBetween))
        }
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "GameZone",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFFFF6600)
            )
            Spacer(Modifier.height(32.dp))
            BouncingDotsAnimation()
        }
        LaunchedEffect(true) {
            delay(3000L)
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}
