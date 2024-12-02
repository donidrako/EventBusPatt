package com.mx.eventbuspatt.login.data

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var INSTANCE: LoginDatabase? = null

    fun getDatabase(context: Context): LoginDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                LoginDatabase::class.java,
                "login_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
