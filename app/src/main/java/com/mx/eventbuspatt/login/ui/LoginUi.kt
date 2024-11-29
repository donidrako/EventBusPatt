package com.mx.eventbuspatt.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mx.eventbuspatt.R


@Composable
fun LoginUi(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Login(Modifier.align(Alignment.Center), viewModel)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {
    // Estados compartidos para los campos de texto para poder habilitar el boton de inicio de sesion
    //var usuario by remember { mutableStateOf("") } //get and Set VAlue modificaciones solo desde la vista
    //var password by remember { mutableStateOf("") }
    //MODIFICAIONES DESDE EL VIEW MODEL DE MANERA DINAMICA
    val usuario: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnbale: Boolean by viewModel.loginEnbale.observeAsState(initial = false)
    Column(modifier = modifier)
    {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))//Centrar de manera horizontal el componente en este caso imagen
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentesUserEditText(
        UserEditText(
            usuario = usuario,
            {
                viewModel.onUserChange(
                    it,
                    password
                )
            } // Lambda para actualizar el estado para hablitar el boton
        )
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentes
        PasswordEditText(
            (password),
            { viewModel.onUserChange(usuario, it) }
        )
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentes
        ForgotPassword(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp)) //Separacion entre componentes
        // Centra el botón horizontalmente
        ButtonLoginStart(loginEnbale) { viewModel.onLoginSelected() }

    }
}

@Composable
fun ButtonLoginStart(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = loginEnable  // Verifica si este valor es actualizado correctamente.
    )
    {
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
    TextField(
        value = password,
        onValueChange = { onPasswordChange(it) }, // Actualiza el estado a través del callback
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun UserEditText(usuario: String, onUserChange: (String) -> Unit) {
    TextField(
        value = usuario,
        onValueChange = { onUserChange(it) }, // Actualiza el estado a través del callback
        placeholder = { Text(text = "Usuario") },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Usuario") },
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
