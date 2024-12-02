package com.mx.eventbuspatt.loginModule.ui

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

/**
 * Composable principal que muestra la interfaz de usuario para el inicio de sesión.
 * Recibe el ViewModel para gestionar los datos del usuario.
 */
@Composable
fun LoginUi(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center), viewModel) // Llama a la función Login con el ViewModel
    }
}

/**
 * Composable que muestra el formulario de inicio de sesión con los campos de usuario y contraseña,
 * y el botón de inicio de sesión. La interfaz se actualiza de forma reactiva según el estado del ViewModel.
 */
@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {
    // Estados observados desde el ViewModel para los campos de texto
    val usuario: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally)) // Imagen centrada en la parte superior
        Spacer(modifier = Modifier.padding(16.dp)) // Separación entre componentes
        UserEditText(usuario = usuario) { // Campo de texto para el usuario
            viewModel.onUserChange(it, password) // Actualiza el estado del usuario y la contraseña
        }
        Spacer(modifier = Modifier.padding(16.dp)) // Separación entre componentes
        PasswordEditText(password) { // Campo de texto para la contraseña
            viewModel.onUserChange(usuario, it) // Actualiza el estado del usuario y la contraseña
        }
        Spacer(modifier = Modifier.padding(16.dp)) // Separación entre componentes
        ForgotPassword(modifier = Modifier.align(Alignment.CenterHorizontally)) // Enlace para recuperar contraseña
        Spacer(modifier = Modifier.padding(16.dp)) // Separación entre componentes
        ButtonLoginStart(loginEnable) { viewModel.onLoginSelected() } // Botón de inicio de sesión
    }
}

/**
 * Composable que muestra el botón de "Iniciar Sesión" y lo habilita o deshabilita
 * según el estado de la variable `loginEnable`.
 */
@Composable
fun ButtonLoginStart(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = loginEnable // Habilita o deshabilita el botón basado en el estado
    ) {
        Text("Iniciar Sesión")
    }
}

/**
 * Composable para mostrar el texto "Olvidaste la contraseña?" como un enlace clickable.
 */
@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidaste la contraseña?",
        modifier = modifier.clickable { /* Implementar acción para recuperar la contraseña */ },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF9C27B0) // Color morado
    )
}

/**
 * Composable para el campo de texto de la contraseña. Aplica una transformación visual
 * para ocultar el texto ingresado y configura las opciones del teclado.
 */
@Composable
fun PasswordEditText(password: String, onPasswordChange: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onPasswordChange(it) }, // Actualiza el estado de la contraseña
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation(), // Oculta la contraseña al ingresarla
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // Teclado para contraseñas
        singleLine = true,
        maxLines = 1
    )
}

/**
 * Composable para el campo de texto del usuario (correo electrónico en este caso).
 * Permite la entrada del correo electrónico y se asegura de que sea validado correctamente.
 */
@Composable
fun UserEditText(usuario: String, onUserChange: (String) -> Unit) {
    TextField(
        value = usuario,
        onValueChange = { onUserChange(it) }, // Actualiza el estado del correo electrónico
        placeholder = { Text(text = "Usuario") },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), // Teclado para correos electrónicos
        singleLine = true,
        maxLines = 1
    )
}

/**
 * Composable que muestra la imagen en la parte superior de la pantalla de inicio de sesión.
 * Se utiliza un recurso de imagen local para este propósito.
 */
@Composable
fun HeaderImage(modifier: Modifier) {
    val redondearImage = painterResource(id = R.drawable.login_image) // Imagen a mostrar
    Image(
        painter = redondearImage,
        contentDescription = "Header", // Descripción de la imagen para accesibilidad
        modifier = modifier
    )
}
