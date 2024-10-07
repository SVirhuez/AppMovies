package com.reto.softek.domain.repository

import com.reto.softek.domain.models.Pelicula

interface PeliculaRepository {

    suspend fun getAllPeliculas(): List<Pelicula>
    suspend fun getPeliculasDataBase(): List<Pelicula>
}