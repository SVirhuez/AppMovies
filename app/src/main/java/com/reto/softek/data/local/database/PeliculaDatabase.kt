package com.reto.softek.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.reto.softek.data.local.dao.PeliculaDao
import com.reto.softek.data.local.entity.PeliculaEntity

@Database(entities = [PeliculaEntity::class], version = 1, exportSchema = false)
abstract class PeliculaDatabase: RoomDatabase() {

    abstract fun peliculaDao(): PeliculaDao
}