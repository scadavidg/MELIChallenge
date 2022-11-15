package com.melichallenge.di

import org.koin.dsl.module

val applicationModule = module(override = true) {
    // viewModels
}

val modules = listOf(applicationModule, domainModule, dataModule)
