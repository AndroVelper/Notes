package com.shubham.notes.di

import androidx.room.Room
import com.shubham.notes.database.DatabaseInstance
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(get(), DatabaseInstance::class.java, "app_database").build() }
    single { get<DatabaseInstance>().daoImpl() }
}