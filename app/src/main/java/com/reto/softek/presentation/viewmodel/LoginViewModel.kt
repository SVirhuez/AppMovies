package com.reto.softek.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.reto.softek.presentation.navigation.AppScreens
import com.reto.softek.utils.validarContraseña
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import java.text.Normalizer
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _user = MutableLiveData<String>()
    var user : LiveData<String> = _user

    private val _password = MutableLiveData<String>()
    var password : LiveData<String> = _password

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading : LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    fun onLoginChange(user:String, password:String){
        _user.value = user
        _password.value = password
    }

    suspend fun onLogin(onSuccess: () -> Unit) {
        if (_user.value.isNullOrEmpty() || _password.value.isNullOrEmpty()) {
            _errorMessage.value = "El usuario y la contraseña no pueden estar vacíos."
            return
        }
        _isLoading.value = true
        clearErrorMessage()
        delay(4000)
        if(_user.value == "Admin" && !validarContraseña(_password.value.toString())){
            _errorMessage.value = "El usuario y la contraseña no son corectos."
            _isLoading.value = false
            return
        }
        _isLoading.value = false
        onSuccess()
    }

    private fun clearErrorMessage() {
        _errorMessage.value = ""
    }
}