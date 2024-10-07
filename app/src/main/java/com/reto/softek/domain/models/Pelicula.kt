package com.reto.softek.domain.models

data class Pelicula(
    val id:Int,
    val poster_path:String,
    val title:String,
    val vote_average:String,
    val release_date:String,
    val overview:String,
)