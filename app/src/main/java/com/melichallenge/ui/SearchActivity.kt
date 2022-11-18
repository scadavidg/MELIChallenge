package com.melichallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.melichallenge.databinding.ActivitySearchBinding
import com.melichallenge.ui.searchresult.SearchResultViewModel
import com.melichallenge.utils.ErrorHandler
import com.melichallenge.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : AppCompatActivity(), ErrorHandler {

    private val binding by viewBinding(ActivitySearchBinding::inflate)
    private val viewModel: SearchResultViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
