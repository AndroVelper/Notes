package com.shubham.notes.screens.addNote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.shubham.notes.navigation.MyNavigation
import com.shubham.notes.navigation.NavDestinations

@Composable
fun AddNoteScreen(navController: NavController) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Rounded.Refresh, contentDescription = "Add Button")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "screen 2")
        }
    }
}