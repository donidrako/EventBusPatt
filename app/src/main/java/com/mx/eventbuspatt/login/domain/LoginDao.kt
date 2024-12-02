package com.mx.eventbuspatt.login.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {

    @Insert
    suspend fun insert(loginEntity: LoginEntity)

    @Query("SELECT * FROM loginUsers WHERE usuario = :usuario AND password = :password LIMIT 1")
    suspend fun getUser(usuario: String, password: String): LoginEntity?
}
