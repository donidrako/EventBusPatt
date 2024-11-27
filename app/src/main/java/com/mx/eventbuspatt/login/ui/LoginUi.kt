package com.mx.eventbuspatt.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
  Column (modifier = modifier)
  {
      HeaderImage()
      UserEditText()
      PasswordEditText()
  }
}

@Composable
fun PasswordEditText() {
    var password by remember { mutableStateOf("") } // Estado para el contenido del TextField
    var isFocused by remember { mutableStateOf(false) } // Estado para saber si está enfocado

    TextField(
        value = password,
        onValueChange = {
            password = it

        },

        label = {
            if(!isFocused && password.isEmpty()) {
                Text("Password")
            }
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
}

@Composable
fun UserEditText() {
    var usuario by remember { mutableStateOf("") } // Estado para el contenido del TextField
    var isFocused by remember { mutableStateOf(false) } // Estado para saber si está enfocado

    TextField(
        value = usuario,
        onValueChange = {
            usuario = it

        },

        label = {
            if(!isFocused && usuario.isEmpty()) {
                Text("Usuario")
            }
        },


    )
}



@Composable
fun HeaderImage() {
    val redondearImage = painterResource(id = R.drawable.login_image)

    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = redondearImage,
            contentDescription = "Header"
        )
    }
}
