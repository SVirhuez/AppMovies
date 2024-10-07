package com.reto.softek.data.remote.network

import com.reto.softek.data.remote.PeliculaApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()


    val api: PeliculaApiService by lazy {
        retrofit.create(PeliculaApiService::class.java)
    }
}
