package com.example.rollandcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.rollandcode.ui.theme.RollandCodeTheme
import androidx.navigation.compose.rememberNavController
import com.example.rollandcode.navigation.AppNav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollandCodeTheme {
                val navController = rememberNavController()
                AppNav(navController = navController)
            }
        }
    }
}