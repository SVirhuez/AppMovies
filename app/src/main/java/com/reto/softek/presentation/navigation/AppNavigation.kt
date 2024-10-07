package com.reto.softek.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reto.softek.presentation.ui.DetalleScreen
import com.reto.softek.presentation.ui.LoginScreen
import com.reto.softek.presentation.viewmodel.LoginViewModel
import com.reto.softek.presentation.ui.PeliculasScreen
import com.reto.softek.presentation.viewmodel.PeliculaSharedViewModel
import com.reto.softek.presentation.viewmodel.PeliculaViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val sharedViewModel: PeliculaSharedViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        composable(
            AppScreens.LoginScreen.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { -it }) + fadeIn(animationSpec = tween(durationMillis = 2000)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) + fadeOut(animationSpec = tween(durationMillis = 2000)) }) {
            val viewModel: LoginViewModel = hiltViewModel()
            LoginScreen(viewModel = viewModel, navController)
        }
        composable(
            AppScreens.PeliculasScreen.route,
            enterTransition = {slideInHorizontally(initialOffsetX = { -it }) + fadeIn(animationSpec = tween(durationMillis = 2000)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) + fadeOut(animationSpec = tween(durationMillis = 2000)) }) {
            val viewModel: PeliculaViewModel = hiltViewModel()
            PeliculasScreen(
                viewModel = viewModel,
                sharedViewModel = sharedViewModel,
                navController = navController
            )
        }
        composable(
            AppScreens.DetalleScreen.route,
            enterTransition = {slideInHorizontally(initialOffsetX = { -it }) + fadeIn(animationSpec = tween(durationMillis = 2000)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) + fadeOut(animationSpec = tween(durationMillis = 2000)) }) {
            val viewModel: PeliculaViewModel = hiltViewModel()
            DetalleScreen(
                viewModel = viewModel,
                sharedViewModel = sharedViewModel,
                navController = navController
            )
        }
    }
}

