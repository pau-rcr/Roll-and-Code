package com.example.rollandcode.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Orange = Color(0xFFFF9800)
val DarkBackground = Color(0xFF181A20)

private val DarkColors = darkColorScheme(
    primary = Orange,
    onPrimary = Color.Black,
    secondary = Orange,
    tertiary = Orange,
    background = DarkBackground,
    surface = DarkBackground,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun RollandCodeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = Typography,
        shapes = CustomShapes,         // mis shapes
        content = content
    )
}
