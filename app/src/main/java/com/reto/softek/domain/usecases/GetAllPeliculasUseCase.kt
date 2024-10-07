package com.reto.softek.domain.usecases

import com.reto.softek.domain.models.Pelicula
import com.reto.softek.domain.repository.PeliculaRepository
import javax.inject.Inject

class GetAllPeliculasUseCase @Inject constructor( private val peliculaRepository: PeliculaRepository) {

    suspend fun getPeliculasFromApi(): List<Pelicula>{
        return peliculaRepository.getAllPeliculas()
    }

    suspend fun getPeliculasFromDataBase(): List<Pelicula>{
        return peliculaRepository.getPeliculasDataBase()
    }
}