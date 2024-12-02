package com.mx.eventbuspatt.login.domain

import com.mx.eventbuspatt.login.data.LoginDao

class LoginRepository(private val dao: LoginDao) {
    suspend fun addUser(user: LoginEntity) = dao.insertUser(user)
    suspend fun fetchUser(id: Int) = dao.getUserById(id)
}
