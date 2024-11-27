package com.mx.eventbuspatt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mx.eventbuspatt.login.ui.LoginUi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
   enableEdgeToEdge()
        setContent{
       LoginUi()
        }
    }
}