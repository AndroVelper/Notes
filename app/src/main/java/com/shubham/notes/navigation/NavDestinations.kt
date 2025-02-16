package com.shubham.notes.navigation

sealed class NavDestinations(val route: String) {
    data object DashboardScreen : NavDestinations("dashboard_Screen")
    data object AddNoteScreen : NavDestinations("add_note_screen")
}