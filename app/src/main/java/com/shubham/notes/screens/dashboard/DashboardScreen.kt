package com.shubham.notes.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shubham.notes.navigation.NavDestinations
import com.shubham.notes.screens.common.GetTextFields


@Composable
fun DashboardScreen(navController: NavController) {
    val title = remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(NavDestinations.AddNoteScreen.route)
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add Button")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(vertical = innerPadding.calculateTopPadding() + 20.dp , horizontal = 15.dp)) {
            GetTextFields(
                title = title,
                placeholderText = "Search Here",
                isSingleLine = true,
                cornerRadius = 20.dp,
                trailingIcon = {
                    if (title.value.isEmpty()) {
                        return@GetTextFields
                    }
                    IconButton(onClick = { title.value = "" }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
                    }
                })
        }
    }
}

