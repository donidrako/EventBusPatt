package com.mx.eventbuspatt.login.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loginUsers")
data class LoginEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val usuario: String,
    val password: String
)