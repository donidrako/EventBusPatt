package com.mx.eventbuspatt.login.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mx.eventbuspatt.login.domain.LoginEntity

@Dao
interface LoginDao {
    @Insert
    suspend fun insertUser(user: LoginEntity)

    @Query("SELECT * FROM loginUsers WHERE id = :id")
    suspend fun getUserById(id: Int): LoginEntity?
}
