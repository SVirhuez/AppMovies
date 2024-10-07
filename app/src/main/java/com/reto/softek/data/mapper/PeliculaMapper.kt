package com.reto.softek.data.mapper

import com.reto.softek.data.local.entity.PeliculaEntity
import com.reto.softek.data.remote.PeliculaDto
import com.reto.softek.domain.models.Pelicula

fun PeliculaDto.toDomain(): Pelicula {
    return Pelicula(
        id = this.id,
        title = this.title,
        poster_path = this.poster_path,
        vote_average = this.vote_average,
        release_date = this.release_date,
        overview = this.overview
    )
}

fun PeliculaDto.toEntity(): PeliculaEntity {
    return PeliculaEntity(
        id = this.id,
        title = this.title,
        posterPath = this.poster_path,
        vote_average = this.vote_average,
        release_date = this.release_date,
        overview = this.overview
    )
}

fun PeliculaEntity.toDomain():Pelicula{
    return Pelicula(
        id = this.id,
        title = this.title,
        poster_path = this.posterPath,
        vote_average = this.vote_average,
        release_date = this.release_date,
        overview = this.overview
    )
}