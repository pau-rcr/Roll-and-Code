# 🎮 GameZone – Tienda de Videojuegos  

Aplicación móvil desarrollada en **Kotlin con Jetpack Compose**, que implementa un sistema de **registro y login optimizado para dispositivos móviles**, con diseño minimalista y validaciones en tiempo real.  

---
  ### 🧑‍💻 Desarrollado por:

- **Paula Caro Romero**
- **Valentina Ruiz Iglesias**
---

## 📱 Descripción del proyecto  

**GameZone** es una app de tienda digital que permite a los usuarios explorar un catálogo de videojuegos para distintas plataformas (consolas y PC), visualizar títulos destacados, y gestionar su perfil de usuario.  

El sistema incluye pantallas de **registro y login** la cual permitira registrarse al usuario, además de una vista de **catálogo**, donde se muestran los juegos disponibles con su respectiva imagen, nombre y precio.  
Su diseño está inspirado en tiendas reales como Steam o PlayStation Store, pero adaptado a una experiencia minimalista, limpia y funcional en móviles.  

---

## 🎯 Objetivo  

- Registrar y autenticar usuarios.  
- Mostrar un catálogo de juegos dinámico y atractivo.  
- Mantener una experiencia fluida, moderna y fácil de usar.  

---

## ⚙️ Características principales  

### 🛒 Catálogo de Juegos  
- Lista visual de títulos disponibles (nuevos y clásicos).  
- Muestra categoria, nombres y plataformas.  
- Diseño adaptable a diferentes resoluciones de pantalla.  

### 👤 Sistema de Usuario  
- Registro de nuevos usuarios con validaciones en tiempo real.  
- Inicio de sesión con opción de “recordar usuario”.  
- Perfil editable con datos básicos y foto de perfil.  

### 💾 Persistencia de datos    

- Gestión de usuarios, progresos y sus juegos favoritos.  

### 🎨 Interfaz y diseño  
- Implementación con **Jetpack Compose**.  
- Estilo minimalista, limpio y responsivo.  
- Paleta de colores inspirada en plataformas de gaming.  

---

## 🧱 Estructura del proyecto  
app/
├── manifests/
├── java/
│ └── com.example.rollandcode/
│ ├── data/
│ │ ├── AppDatabase.kt
│ │ ├── Game.kt
│ │ ├── User.kt
│ │ ├── UserDao.kt
│ │ └── UserGame.kt
│ ├── navigation/
│ │ └── AppNav.kt
│ ├── ui/
│ │ └── screens/
│ │ ├── GamesScreen.kt
│ │ ├── LoginScreen.kt
│ │ ├── MenuShellView.kt
│ │ ├── MyGameScreen.kt
│ │ ├── ProfileScreen.kt
│ │ ├── RegisterScreen.kt
│ │ └── SplashScreen.kt
│ └── theme/
│ ├── Color.kt
│ ├── Shapes.kt
│ ├── Theme.kt
│ └── Type.kt
└── res/
└── drawable/ ← imágenes y recursos visuales 

## 🧰 Tecnologías utilizadas  

- **Lenguaje:** Kotlin  
- **Interfaz:** Jetpack Compose   
- **Navegación:** Navigation Compose  
- **Arquitectura:** MVVM simplificada  
- **Entorno de desarrollo:** Android Studio

