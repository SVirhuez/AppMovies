package com.reto.softek.data.repository

import com.reto.softek.data.local.dao.PeliculaDao
import com.reto.softek.data.mapper.toDomain
import com.reto.softek.data.mapper.toEntity
import com.reto.softek.data.remote.PeliculaApiService
import com.reto.softek.domain.models.Pelicula
import com.reto.softek.domain.repository.PeliculaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PeliculaRepositoryImpl
@Inject constructor(
    private val apiService: PeliculaApiService,
    private val peliculaDao: PeliculaDao
) : PeliculaRepository {

    override suspend fun getAllPeliculas(): List<Pelicula> {
        return withContext(Dispatchers.IO) {
        return@withContext  try {
            val response = apiService.getAllPeliculas(apiKey = "f30ad2ef7405953c0a1d7514272c57d7") //f30ad2ef7405953c0a1d7514272c57d7
            val peliculasEntities = response.results.map { it.toEntity() }

            peliculaDao.deleteAll()
            peliculaDao.insertAll(peliculasEntities)
            response.results.map {it.toDomain()}
        } catch (e: Exception) {
            println("RESPUESTA API: "+e.message)
            emptyList()
        }

    }
    }

    override suspend fun getPeliculasDataBase(): List<Pelicula> {
        return withContext(Dispatchers.IO) {
            return@withContext peliculaDao.getAllPeliculasDataBase().map { it.toDomain() }
        }
    }
}