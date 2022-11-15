package com.melichallenge.di

import com.melichallenge.data.repositories.ItemsRepositoryImpl
import com.melichallenge.domain.repositories.ItemsRepository
import com.melichallenge.domain.usecases.SearchItemUseCase
import com.melichallenge.domain.usecases.SearchItemsUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

val domainModule = module {
    // Repositories
    singleBy<ItemsRepository, ItemsRepositoryImpl>()

    // UseCases
    single { SearchItemsUseCase(get()) }
    single { SearchItemUseCase(get()) }
}
