package com.mx.eventbuspatt.login.domain

class LoginRepository(private val loginDao: LoginDao) {

    // Función para insertar un nuevo usuario
    suspend fun insertUser(loginEntity: LoginEntity) {
        loginDao.insert(loginEntity)
    }

    // Función para obtener un usuario por nombre de usuario y contraseña
    suspend fun getUser(usuario: String, password: String): LoginEntity? {
        return loginDao.getUser(usuario, password)
    }
}
