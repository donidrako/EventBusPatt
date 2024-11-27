package com.mx.eventbuspatt.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mx.eventbuspatt.R

@Preview
@Composable
fun LoginUi() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Login(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Login(modifier: Modifier) {
    // Estados compartidos para los campos de texto para poder habilitar el boton de inicio de sesion
    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(modifier = modifier)
    {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))//Centrar de manera horizontal el componente en este caso imagen
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentesUserEditText(
        UserEditText(
            usuario = usuario,
            onUserChange = { usuario = it } // Lambda para actualizar el estado para hablitar el boton
        )
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentes
        PasswordEditText(
            password = password,
            onPasswordChange = { password = it } // Lambda para actualizar el estado para habilitar el boton
        )
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentes
        ForgotPassword(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentes
        // Centra el botón horizontalmente
        ButtonLoginStart(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            usuario = usuario, // Aquí debes pasar el estado del usuario para poder hablitar el botn
            password = password // Aquí debes pasar el estado de la contraseña igual
        )
    }
}

@Composable
fun ButtonLoginStart(
    modifier: Modifier = Modifier,
    usuario: String,
    password: String
) {
    Button(
        onClick = { /* Acción del botón */ },
        modifier = modifier,
        enabled = password.isNotEmpty() && usuario.isNotEmpty() // Botón habilitado/deshabilitado dinámicamente
    ) {
        Text("Iniciar Sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) { //el modifier de este metodo se usa en el clickable
    Text(
        text = "Olvidaste la contraseña?",
        modifier = modifier.clickable { }, // por eso se escribe en minisculo
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF9C27B0)
    )
}

@Composable
fun PasswordEditText(password: String, onPasswordChange: (String) -> Unit) {
    var isFocused by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = Modifier.fillMaxWidth(),//que el edit text abraque toda la pantalla
        label = {
            if (!isFocused && password.isEmpty()) {
                Text("Password")
            }
        },
        visualTransformation = PasswordVisualTransformation(),
        //defines que tipo de datos vas a introducir ejemplo KeyboardType.Password
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,// para que no se aplie el componente edit text si metes un texto largo
        maxLines = 1, // no. de lineas que soporta el edit text
        //Definir los colores de nuestro Edit TExt

    )
}

@Composable
fun UserEditText(usuario: String, onUserChange: (String) -> Unit) {
    var isFocused by remember { mutableStateOf(false) }
    TextField(
        value = usuario,
        onValueChange = onUserChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            if (!isFocused && usuario.isEmpty()) {
                Text("Usuario")
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1

    )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    val redondearImage = painterResource(id = R.drawable.login_image)
    Image(
        painter = redondearImage,
        contentDescription = "Header",
        modifier = modifier
    )
}
