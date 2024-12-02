package com.mx.eventbuspatt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.mx.eventbuspatt.login.data.LoginDatabase
import com.mx.eventbuspatt.login.ui.LoginUi
import com.mx.eventbuspatt.login.ui.LoginViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // Llamar una sola vez

        // Crear la base de datos y obtener el DAO
        val db = Room.databaseBuilder(applicationContext, LoginDatabase::class.java, "usuarios").build()
        val dao = db.loginDao()

        val viewModel = LoginViewModel(dao)

        setContent {
            // Pasar el ViewModel al UI
            LoginUi(viewModel = viewModel)
        }
    }
}
