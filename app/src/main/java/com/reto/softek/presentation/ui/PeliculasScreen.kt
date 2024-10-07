package com.reto.softek.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.reto.softek.presentation.viewmodel.PeliculaSharedViewModel
import com.reto.softek.presentation.viewmodel.PeliculaViewModel


@Composable
fun PeliculasScreen(
    navController: NavController,
    viewModel: PeliculaViewModel,
    sharedViewModel: PeliculaSharedViewModel
) {

    val peliculas = viewModel.peliculas.collectAsState().value

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Peliculas",
            fontSize = 36.sp,
            modifier = Modifier.background(Color.Black).fillMaxWidth().padding(8.dp),
            color = Color.White

        )

        if (peliculas.isEmpty()) {
            // Si la lista está vacía, mostrar el mensaje
            Text(
                text = "No hay resultados",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge
            )
        }else{
            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize())
            {
                items(peliculas) { pelicula ->
                    PeliculaItem(pelicula, onItemClick = { selectedPelicula ->
                        sharedViewModel.selectPelicula(selectedPelicula)
                        navController.navigate("detalle_screen")
                    })
                }
            }
        }
    }
}





