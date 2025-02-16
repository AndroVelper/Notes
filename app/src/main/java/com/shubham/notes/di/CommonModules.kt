package com.shubham.notes.di

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * This module has the most priority as this contains the part which should
 * be initialized first as this contain the most dependent stuff
 * **/
val commonModules = module {
    single { androidContext() }
}