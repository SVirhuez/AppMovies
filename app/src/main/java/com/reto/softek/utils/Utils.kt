package com.reto.softek.utils

fun validarContraseña(password: String): Boolean{
    val regex = Regex("Password[*]123")
    // Contraseña válida
    return regex.matches(password)
}