package com.reto.softek.di

import android.app.Application
import android.content.Context
import com.reto.softek.data.local.dao.PeliculaDao
import com.reto.softek.data.local.database.PeliculaDatabase
import com.reto.softek.data.remote.PeliculaApiService
import com.reto.softek.data.remote.network.RetrofitInstance
import com.reto.softek.data.repository.PeliculaRepositoryImpl
import com.reto.softek.domain.repository.PeliculaRepository
import com.reto.softek.domain.usecases.GetAllPeliculasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  AppModule {

    @Provides
    fun providePeliculaApiService(): PeliculaApiService {
        return RetrofitInstance.api
    }


    @Provides
    fun providePeliculaRepository(apiService: PeliculaApiService,peliculaDao: PeliculaDao): PeliculaRepository {
        return PeliculaRepositoryImpl(apiService,peliculaDao)
    }

    @Provides
    fun provideGetPopularMoviesUseCase(repository: PeliculaRepository): GetAllPeliculasUseCase {
        return GetAllPeliculasUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }
}