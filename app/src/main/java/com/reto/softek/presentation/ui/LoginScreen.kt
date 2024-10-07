package com.reto.softek.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.reto.softek.R
import com.reto.softek.presentation.navigation.AppScreens
import com.reto.softek.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)
        ){
        Login(modifier = Modifier.align(Alignment.Center),viewModel,navController)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavController){
    val user :String by viewModel.user.observeAsState(initial = "")
    val password :String by viewModel.password.observeAsState(initial = "")
    val couritineScope = rememberCoroutineScope()
    val isLoading :Boolean by viewModel.isLoading.observeAsState(initial = false)
    val errorMessage: String by viewModel.errorMessage.observeAsState(initial = "")

    if(isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column (modifier = modifier) {
            CabeceraLogin()

            Text(text = "Ingrese usuario y contraseña",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            UserField(user) { viewModel.onLoginChange(it, password) }
            Spacer(modifier = Modifier.padding(top = 4.dp))
            PasswordField(password) {viewModel.onLoginChange(user, it)}
            Spacer(modifier = Modifier.padding(top = 10.dp))
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = Color.Red, modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally))
            }
            IniciarSesion(navController) {
                couritineScope.launch {
                    viewModel.onLogin {
                        navController.navigate(route = AppScreens.PeliculasScreen.route)
                    }
                }
            }
        }
    }
}

@Composable
fun CabeceraLogin(){
    Image(painter = painterResource(id = R.drawable.ic_movie),
        contentDescription = "Movie Icon",
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField(user:String,onTextfieldChanged:(String) -> Unit){

    TextField(value = user, onValueChange = { onTextfieldChanged(it)}, modifier = Modifier.fillMaxWidth() ,
        placeholder = { Text(text = "Usuario")},
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ))

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password:String,onTextfieldChanged:(String) -> Unit){
    TextField(value = password, onValueChange = {onTextfieldChanged(it)}, modifier = Modifier.fillMaxWidth() ,
        placeholder = { Text(text = "Contraseña")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun IniciarSesion(navController: NavController, onLogin:() -> Unit){
    Button(onClick = {  onLogin() } , modifier = Modifier.fillMaxWidth()) {
        Text(text = "Iniciar sesión")
    }
}

/*navController.navigate(route = AppScreens.PeliculasScreen.route)*/