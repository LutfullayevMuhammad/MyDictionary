package com.lutfullayevmuhammad.mydictionary.core.adapters.details

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecData
import com.lutfullayevmuhammad.mydictionary.databinding.RecItemBinding
import com.lutfullayevmuhammad.mydictionary.databinding.UserItemBinding


class RecAdapterHolder(val binding: RecItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bindDataArabic(data: RecData) {
        binding.dictionaryEnUz.text = data.dictionary
    }

}