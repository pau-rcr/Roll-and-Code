package com.example.rollandcode.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.rollandcode.data.AppDatabase
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val db = remember { AppDatabase.getDatabase(context) }
    val coroutineScope = rememberCoroutineScope()
    var loginError by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    fun validate() : Boolean {
        emailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        passwordError = password.length < 6
        return !(emailError || passwordError)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Iniciar sesión",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo @duoc.cl") },
            isError = emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        if (emailError) Text("Correo inválido", color = MaterialTheme.colorScheme.error)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            isError = passwordError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        if (passwordError) Text("Contraseña debe tener al menos 6 caracteres", color = MaterialTheme.colorScheme.error)

        Spacer(Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
            Text("Recordar sesión", color = MaterialTheme.colorScheme.onBackground)
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    val user = db.userDao().login(email, password)
                    if (user != null) {
                        val userNameSafe = java.net.URLEncoder.encode(user.name, "utf-8")
                        val userEmailSafe = java.net.URLEncoder.encode(user.email, "utf-8")
                        navController.navigate("home/${userNameSafe}/${userEmailSafe}") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        loginError = "Usuario o contraseña incorrectos."
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
        if (loginError.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = loginError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("¿No tienes cuenta?", color = MaterialTheme.colorScheme.onBackground)
            TextButton(onClick = { navController.navigate("register") }) {
                Text("Regístrate", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
