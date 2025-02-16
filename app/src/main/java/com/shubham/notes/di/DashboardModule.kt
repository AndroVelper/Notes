package com.shubham.notes.di

import com.shubham.notes.screens.dashboard.DashboardViewModel
import org.koin.dsl.module

val dashboardModule = module {
    single { DashboardViewModel(get()) }
}