package com.melichallenge.di

import com.melichallenge.ui.itemdetail.ItemDetailViewModel
import com.melichallenge.ui.searchresult.SearchResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module() {
    // viewModels
    viewModel { SearchResultViewModel(get()) }
    viewModel { ItemDetailViewModel(get()) }
}
