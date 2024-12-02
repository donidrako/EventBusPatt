package com.mx.eventbuspatt.loginModule.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loginUsers")
data class LoginEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val usuario: String,
    val password: String
)