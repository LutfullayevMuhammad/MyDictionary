package com.lutfullayevmuhammad.mydictionary.core.adapters.home

import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.UserItem
import com.lutfullayevmuhammad.mydictionary.databinding.UserItemBinding

class UserAdapterHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(data: UserItem) {
        binding.dictionaryEnUz.text = data.dictionary
    }

}