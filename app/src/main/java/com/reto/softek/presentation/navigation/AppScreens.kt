package com.reto.softek.presentation.navigation

sealed class AppScreens(val route:String) {

    object LoginScreen: AppScreens(route = "login_screen")
    object PeliculasScreen: AppScreens(route = "peliculas_screen")
    object DetalleScreen: AppScreens(route = "detalle_screen")

}