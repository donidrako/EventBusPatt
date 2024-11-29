package com.mx.eventbuspatt.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() { // la clase extiende de ViewModel()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email //la variable de esta linea es de tipo  -> LiveData<String>
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> =
        _password //la variable de esta linea es de tipo  -> LiveData<String>
    private val _loginEnbale = MutableLiveData<Boolean>(false)
    val loginEnbale: MutableLiveData<Boolean> =
        _loginEnbale

    // PARAMETROS DE NETRADA password y usuario
    fun onUserChange(email: String, password: String) {
        //Siempore tendra elk ultimoi valoir del edit text
        _email.value = email
        _password.value = password
        _loginEnbale.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean = password.length > 6 &&
            password.any { it.isUpperCase() } &&// valida que la contraseña cuente con una letra mayuscula
            password.any { it.isDigit() } &&//valida que la contraseña cuente con un numero
            password.any { "!@#$%^&*()-_+=<>?/{}|\\~`".contains(it) }//valida que la contraseña cuente con un carcater especial de la lista

    fun onLoginSelected() {

    }

}