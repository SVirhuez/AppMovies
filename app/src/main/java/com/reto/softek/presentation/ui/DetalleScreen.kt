package com.reto.softek.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.reto.softek.presentation.viewmodel.PeliculaSharedViewModel
import com.reto.softek.presentation.viewmodel.PeliculaViewModel


@Composable
fun DetalleScreen(navController: NavController, viewModel: PeliculaViewModel,sharedViewModel: PeliculaSharedViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        DetalleCabecera(viewModel,sharedViewModel)
    }
}

@Composable
fun DetalleCabecera(viewModel: PeliculaViewModel,sharedViewModel: PeliculaSharedViewModel) {

    val pelicula = sharedViewModel.selectedPelicula.observeAsState()

    pelicula.value?.let {
        MaterialTheme {
            Surface {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Detalle de la Pelicula",
                            fontSize = 24.sp,
                            modifier = Modifier.background(Color.Black).fillMaxWidth().padding(8.dp),
                            color = Color.White

                        )
                        Image(
                            painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/w500/${it.poster_path}"),
                            contentDescription = it.title,
                            Modifier
                                .width(120.dp)
                                .height(200.dp)
                                .padding(top = 5.dp, bottom = 10.dp)
                                .align(Alignment.CenterHorizontally),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = it.title,
                            fontSize = 28.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Text(
                            text = "Nota de pelicula: ${it.vote_average}",
                            fontSize = 15.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Text(
                            text = "Fecha de Lanzamiento: ${it.release_date}\n",
                            fontSize = 15.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Text(
                            text = "Resumen de la pelicula:\n\n${it.overview}",
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    } ?: Text(text = "No se seleccionó ninguna película")
}