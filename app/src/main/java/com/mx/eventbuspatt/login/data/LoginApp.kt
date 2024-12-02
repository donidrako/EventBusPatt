package com.mx.eventbuspatt.login.data

import android.app.Application
import androidx.room.Room

class LoginApp: Application(){
    val room = Room.databaseBuilder(this, LoginDatabase::class.java,"users" ).build()
}