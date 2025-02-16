package com.shubham.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.shubham.notes.navigation.MyNavigation
import com.shubham.notes.screens.dashboard.DashboardScreen
import com.shubham.notes.ui.theme.ComposeNoteApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNoteApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { inner ->
                    inner.toString()
                    MyNavigation()
                }
            }
        }
    }
}

