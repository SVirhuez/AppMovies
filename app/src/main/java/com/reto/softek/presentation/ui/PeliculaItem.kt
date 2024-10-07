package com.reto.softek.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.reto.softek.R
import com.reto.softek.domain.models.Pelicula


@Composable
fun PeliculaItem(pelicula: Pelicula,onItemClick: (Pelicula) -> Unit) {
    val errorImage = painterResource(id = R.drawable.ic_movie)
    Column(modifier = Modifier.padding(16.dp)
        .clickable { onItemClick(pelicula) }) {
        Text(text = pelicula.title)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).
            data("https://image.tmdb.org/t/p/w500/${pelicula.poster_path}").build(),
            contentDescription = pelicula.title,
            modifier = Modifier.size(128.dp),
            contentScale = ContentScale.Crop
        )
    }
}