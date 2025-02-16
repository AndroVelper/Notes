package com.shubham.notes.di

import com.shubham.notes.repo.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }
}