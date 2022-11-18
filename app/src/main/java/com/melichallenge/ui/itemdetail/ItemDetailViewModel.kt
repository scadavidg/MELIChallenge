package com.melichallenge.ui.itemdetail

import androidx.lifecycle.ViewModel
import com.melichallenge.domain.usecases.SearchItemUseCase

class ItemDetailViewModel(private val searchItemUseCase: SearchItemUseCase) : ViewModel()
