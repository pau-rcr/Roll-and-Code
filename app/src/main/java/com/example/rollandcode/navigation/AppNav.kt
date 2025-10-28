package com.example.rollandcode.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rollandcode.ui.screens.LoginScreen
import com.example.rollandcode.ui.screens.RegisterScreen
import com.example.rollandcode.ui.screens.SplashScreen
import com.example.rollandcode.ui.screens.MenuShellView

@Composable
fun AppNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegisterScreen(navController = navController)
        }
        composable("home/{userName}/{userEmail}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            val userEmail = backStackEntry.arguments?.getString("userEmail") ?: ""
            MenuShellView(userName = userName, userEmail = userEmail, navController = navController)
        }
    }
}
