package com.reto.softek.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reto.softek.domain.models.Pelicula
import com.reto.softek.domain.usecases.GetAllPeliculasUseCase
import com.reto.softek.utils.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeliculaViewModel @Inject constructor(
    private val getAllPeliculasUseCase: GetAllPeliculasUseCase,
    private val context: Context
) : ViewModel() {

    private val connectivityObserver = ConnectivityObserver(context)
    private val _peliculas = MutableStateFlow<List<Pelicula>>(emptyList())
    val peliculas: StateFlow<List<Pelicula>> = _peliculas

    init {
        getPeliculas()
    }

    fun getPeliculas() {
        viewModelScope.launch {
            if (connectivityObserver.isConnected()) {
                val result = getAllPeliculasUseCase.getPeliculasFromApi()
                _peliculas.value = result
            }else{

                val result = getAllPeliculasUseCase.getPeliculasFromDataBase()
                _peliculas.value = result
            }

        }
    }
}