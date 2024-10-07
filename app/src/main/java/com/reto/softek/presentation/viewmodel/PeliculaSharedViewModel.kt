package com.reto.softek.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.reto.softek.domain.models.Pelicula
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeliculaSharedViewModel @Inject constructor(): ViewModel(){

    private val _selectedPelicula = MutableLiveData<Pelicula>()
    val selectedPelicula: LiveData<Pelicula> = _selectedPelicula

    fun selectPelicula(pelicula: Pelicula) {
        _selectedPelicula.value = pelicula
    }
}