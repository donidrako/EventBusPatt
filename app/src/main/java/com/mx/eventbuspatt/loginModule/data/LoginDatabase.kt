package com.mx.eventbuspatt.loginModule.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mx.eventbuspatt.loginModule.domain.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
}
