package com.melichallenge.ui.searchresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.melichallenge.databinding.ElementItemBinding
import com.melichallenge.domain.models.ItemList
import com.melichallenge.utils.replaceItems

class ItemsListAdapter : RecyclerView.Adapter<ItemsListViewHolder>() {

    private var contactsList = ArrayList<ItemList>()

    fun setContacts(contactsRequested: ArrayList<ItemList>) {
        contactsList.replaceItems(contactsRequested)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsListViewHolder =
        ItemsListViewHolder(
            ElementItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = contactsList.size

    override fun onBindViewHolder(holder: ItemsListViewHolder, position: Int) {
        holder.bind(contactsList[position], position)
    }
}
