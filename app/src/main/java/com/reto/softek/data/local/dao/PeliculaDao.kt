package com.reto.softek.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reto.softek.data.local.entity.PeliculaEntity

@Dao
interface PeliculaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(peliculas: List<PeliculaEntity>)

    @Query("SELECT * FROM peliculas")
    fun getAllPeliculasDataBase(): List<PeliculaEntity>

    @Query("DELETE FROM peliculas")
    fun deleteAll(): Int
}