package com.example.rollandcode.data

data class UserGame(
    val name: String,
    val genre: String,
    val platform: String,
    val progress: Int, // porcentaje jugado
    val progressDescription: String,
    val imageRes: Int,
)