package com.shubham.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shubham.notes.screens.addNote.AddNoteScreen
import com.shubham.notes.screens.dashboard.DashboardScreen

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = NavDestinations.DashboardScreen.route
    ) {
        composable(NavDestinations.DashboardScreen.route) {
            DashboardScreen(navController)
        }
        composable(NavDestinations.AddNoteScreen.route) {
            AddNoteScreen(navController)
        }
    }
}