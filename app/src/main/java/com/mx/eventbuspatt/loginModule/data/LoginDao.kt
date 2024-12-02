package com.mx.eventbuspatt.loginModule.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mx.eventbuspatt.loginModule.domain.LoginEntity

@Dao
interface LoginDao {

    // Insertar un nuevo usuario
    @Insert
    suspend fun insertUser(user: LoginEntity)

    // Eliminar un usuario por su ID
    @Query("DELETE FROM loginUsers WHERE id = :id")
    suspend fun deleteUserById(id: Int)

    // Actualizar datos de un usuario (incluye contraseña)
    @Update
    suspend fun updateUser(user: LoginEntity)

    // Obtener todos los usuarios como lista
    @Query("SELECT * FROM loginUsers")
    suspend fun getAllUsers(): List<LoginEntity>

    // Obtener todos los usuarios en tiempo real como LiveData
    @Query("SELECT * FROM loginUsers")
    fun getAllUsersLiveData(): LiveData<List<LoginEntity>>

    // Obtener un usuario por su ID
    @Query("SELECT * FROM loginUsers WHERE id = :id")
    suspend fun getUserById(id: Int): LoginEntity?

    // Actualizar la contraseña de un usuario por su ID
    @Query("UPDATE loginUsers SET password = :newPassword WHERE id = :id")
    suspend fun updatePasswordById(id: Int, newPassword: String)

    // Obtener todos los usuarios y contraseñas
    @Query("SELECT id, usuario, password FROM loginUsers")
    suspend fun getAllUsersAndPasswords(): List<LoginEntity>

    // Eliminar todos los usuarios
    @Query("DELETE FROM loginUsers")
    suspend fun deleteAllUsers()
    abstract fun validateLogin(email: String, password: String): Boolean
}
