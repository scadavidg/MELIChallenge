package com.melichallenge.di

import com.melichallenge.data.repositories.ItemsRepositoryImpl
import com.melichallenge.domain.repositories.ItemsRepository
import com.melichallenge.domain.usecases.SearchItemUseCase
import com.melichallenge.domain.usecases.SearchResultUseCase
import org.koin.dsl.module

val domainModule = module {
    // Repositories
    single<ItemsRepository> { ItemsRepositoryImpl(get()) }

    // UseCases
    single { SearchResultUseCase(get()) }
    single { SearchItemUseCase(get()) }
}
