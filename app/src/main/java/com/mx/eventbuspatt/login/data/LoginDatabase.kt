package com.mx.eventbuspatt.login.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mx.eventbuspatt.login.domain.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
}
