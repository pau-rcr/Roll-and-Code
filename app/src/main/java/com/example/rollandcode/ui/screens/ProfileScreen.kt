package com.example.rollandcode.ui.screens

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

val BitmapSaver: Saver<Bitmap?, Any> = mapSaver(
    save = { bitmap ->
        if (bitmap == null) emptyMap()
        else mapOf(
            "byteArray" to with(java.io.ByteArrayOutputStream()) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, this)
                toByteArray()
            }
        )
    },
    restore = { restored ->
        val bytes = restored["byteArray"] as? ByteArray
        if (bytes != null) android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        else null
    }
)

@Composable
fun ProfileScreen(userName: String, userEmail: String) {
    var profilePicture by rememberSaveable(stateSaver = BitmapSaver) { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        if (bitmap != null) profilePicture = bitmap
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Perfil de usuario", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        if (profilePicture != null) {
            Image(
                bitmap = profilePicture!!.asImageBitmap(),
                contentDescription = "Foto de perfil",
                modifier = Modifier.size(120.dp)
            )
        } else {
            Icon(Icons.Default.Person, contentDescription = "Sin foto", modifier = Modifier.size(120.dp))
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { launcher.launch(null) }) {
            Text("Tomar foto de perfil")
        }
        Spacer(Modifier.height(16.dp))
        Text("Nombre: $userName", style = MaterialTheme.typography.bodyLarge)
        Text("Correo: $userEmail", style = MaterialTheme.typography.bodyLarge)
    }
}
