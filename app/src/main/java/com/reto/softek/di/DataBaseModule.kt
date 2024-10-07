package com.reto.softek.di

import android.content.Context
import androidx.room.Room
import com.reto.softek.data.local.dao.PeliculaDao
import com.reto.softek.data.local.database.PeliculaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PeliculaDatabase {
        return Room.databaseBuilder(
            context,
            PeliculaDatabase::class.java,
            "pelicula_database"
        ).build()
    }

    @Provides
    fun providePeliculaDao(database: PeliculaDatabase): PeliculaDao {
        return database.peliculaDao()
    }

}