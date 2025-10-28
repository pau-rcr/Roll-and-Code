package com.example.rollandcode.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Checkbox
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.rollandcode.data.User
import com.example.rollandcode.data.AppDatabase
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController) {
    var registerError by remember { mutableStateOf("") }
    val context = LocalContext.current
    val db = remember { AppDatabase.getDatabase(context) }
    val coroutineScope = rememberCoroutineScope()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var nameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPassError by remember { mutableStateOf(false) }

    fun validate(): Boolean {
        var valid = true
        nameError = name.isBlank()
        emailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.endsWith("@duoc.cl")
        passwordError = password.length < 6
        confirmPassError = password != confirmPassword
        if (nameError || emailError || passwordError || confirmPassError) valid = false
        return valid
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre completo") },
            isError = nameError,
            modifier = Modifier.fillMaxWidth()
        )
        if (nameError) Text("El nombre no puede estar vacío", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo @duoc.cl") },
            isError = emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        if (emailError) Text("Correo inválido o no termina en @duoc.cl", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            isError = passwordError,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (passwordError) Text("Debe tener al menos 6 caracteres", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar contraseña") },
            isError = confirmPassError,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (confirmPassError) Text("Las contraseñas no coinciden", color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono (opcional)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text("Recordarme", color = MaterialTheme.colorScheme.onBackground)
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                if (validate()) {
                    coroutineScope.launch {
                        val existing = db.userDao().getUserByEmail(email)
                        if (existing == null) {
                            db.userDao().insertUser(User(name = name, email = email, password = password))
                            navController.navigate("login")
                        } else {
                            registerError = "Ya existe un usuario con ese correo."
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
        if (registerError.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            Text(
                text = registerError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(Modifier.height(20.dp))

        TextButton(onClick = { navController.navigate("login") }) {
            Text("Volver a Iniciar sesión", color = MaterialTheme.colorScheme.primary)
        }
    }
}
