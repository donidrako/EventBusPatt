package com.mx.eventbuspatt.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.eventbuspatt.login.data.LoginDao
import com.mx.eventbuspatt.login.domain.LoginEntity
import kotlinx.coroutines.launch

/**
 * ViewModel para gestionar la lógica y el estado de la pantalla de inicio de sesión.
 * Esta clase sigue el patrón de arquitectura MVVM, donde actúa como el puente
 * entre la UI (Vista) y la lógica de negocio.
 */
class LoginViewModel(private val repository: LoginDao) : ViewModel() {
    // LiveData observable para el correo electrónico ingresado. La UI observa este valor para mostrarlo.
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    // LiveData observable para la contraseña ingresada.
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    // LiveData para habilitar o deshabilitar el botón de inicio de sesión, según la validación del correo y la contraseña.
    private val _loginEnable = MutableLiveData<Boolean>(false)
    val loginEnable: LiveData<Boolean> = _loginEnable

    /**
     * Actualiza los valores del correo electrónico y la contraseña e evalúa si el botón de inicio de sesión debe estar habilitado.
     *
     * @param email El correo electrónico ingresado por el usuario.
     * @param password La contraseña ingresada por el usuario.
     */
    fun onUserChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    /**
     * Valida si el correo electrónico es correcto.
     *
     * @param email El correo electrónico a validar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    /**
     * Valida si la contraseña es válida.
     * La contraseña debe tener más de 6 caracteres, al menos una letra mayúscula,
     * al menos un número y al menos un carácter especial.
     *
     * @param password La contraseña a validar.
     * @return true si la contraseña cumple con los requisitos, false en caso contrario.
     */
    private fun isValidPassword(password: String): Boolean = password.length > 6 &&
            password.any { it.isUpperCase() } && // Valida que la contraseña tenga al menos una letra mayúscula
            password.any { it.isDigit() } && // Valida que la contraseña tenga al menos un número
            password.any { "!@#$%^&*()-_+=<>?/{}|\\~`".contains(it) } // Valida que la contraseña tenga al menos un carácter especial

    /**
     * Método que se llama cuando el usuario selecciona el botón de inicio de sesión.
     * Actualmente no tiene implementación.
     */
    fun onLoginSelected() {
        val email = _email.value ?: return
        val password = _password.value ?: return

        viewModelScope.launch {
            val isValidUser = repository.validateLogin(email, password)
            if (isValidUser) {
                // Navegar a la siguiente pantalla
            } else {
                // Mostrar un mensaje de error
            }
        }
    }
}
