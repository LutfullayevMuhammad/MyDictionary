package com.lutfullayevmuhammad.mydictionary.core.adapters.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecData
import com.lutfullayevmuhammad.mydictionary.databinding.RecItemBinding
import com.lutfullayevmuhammad.mydictionary.databinding.UserItemBinding

class RecAdapter : RecyclerView.Adapter<RecAdapterHolder>() {

    var data = ArrayList<RecData>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecAdapterHolder =
        RecAdapterHolder(
            RecItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecAdapterHolder, position: Int) =
        holder.bindDataArabic(data[position])

    override fun getItemCount(): Int = data.size

}