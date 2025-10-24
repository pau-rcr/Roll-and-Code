package com.example.rollandcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rollandcode.ui.theme.RollandCodeTheme

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rollandcode.ui.screens.HomeScreen
import com.example.rollandcode.ui.screens.LoginScreen
import com.example.rollandcode.ui.screens.RegisterScreen
import com.example.rollandcode.ui.screens.SplashScreen
import com.example.rollandcode.ui.theme.RollandCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollandCodeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { SplashScreen(navController) }
                    composable("login") { LoginScreen(navController) }
                    composable("register") { RegisterScreen(navController) }
                    composable("home/{userName}") { backStackEntry ->
                        HomeScreen(
                            userName = backStackEntry.arguments?.getString("userName") ?: "",
                            navController = navController
                        )
                    }

                }
            }
        }
    }
}