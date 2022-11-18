package com.melichallenge.ui.searchresult

import androidx.fragment.app.Fragment
import com.example.melichallenge.R
import com.example.melichallenge.databinding.FragmentSearchResultBinding
import com.melichallenge.utils.ErrorHandler
import com.melichallenge.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchResultFragment : Fragment(R.layout.fragment_search_result), ErrorHandler {

    private val binding by viewBinding(FragmentSearchResultBinding::bind)
    private val viewModel: SearchResultViewModel by viewModel()
}
