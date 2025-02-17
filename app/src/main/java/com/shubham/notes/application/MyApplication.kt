package com.shubham.notes.application

import android.app.Application
import com.shubham.notes.di.commonModules
import com.shubham.notes.di.dashboardModule
import com.shubham.notes.di.databaseModule
import com.shubham.notes.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {


    /**
     * please check the commonModules
     * are the most important and need to
     * be init before all as it contains all
     * the context and all the dependencies
     * **/
    override fun onCreate() {
        super.onCreate()
        // the first three module be in same hierarchy rest hierarchy can be changed.
        startKoin {
            androidContext(this@MyApplication)
            modules( databaseModule, repositoryModule, dashboardModule)
        }
    }
}