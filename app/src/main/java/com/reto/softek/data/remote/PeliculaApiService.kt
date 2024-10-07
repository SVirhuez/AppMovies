package com.reto.softek.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PeliculaApiService {

    @GET("movie/popular")
    suspend fun getAllPeliculas(@Query("api_key") apiKey: String): PeliculaResponse
}

data class PeliculaResponse(
    val results: List<PeliculaDto>
)

data class PeliculaDto(
    val id: Int,
    val poster_path: String,
    val title: String,
    val vote_average:String,
    val release_date:String,
    val overview: String
)