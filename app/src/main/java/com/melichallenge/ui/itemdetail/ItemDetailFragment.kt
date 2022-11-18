package com.melichallenge.ui.itemdetail

import androidx.fragment.app.Fragment
import com.example.melichallenge.R
import com.example.melichallenge.databinding.FragmentItemDetailBinding
import com.melichallenge.utils.ErrorHandler
import com.melichallenge.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailFragment : Fragment(R.layout.fragment_item_detail), ErrorHandler {

    private val binding by viewBinding(FragmentItemDetailBinding::bind)
    private val viewModel: ItemDetailViewModel by viewModel()
}
