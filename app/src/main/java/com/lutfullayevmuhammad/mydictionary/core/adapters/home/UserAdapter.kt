package com.lutfullayevmuhammad.mydictionary.core.adapters.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.UserItem
import com.lutfullayevmuhammad.mydictionary.databinding.UserItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapterHolder>() {

    var data = ArrayList<UserItem>()
    @SuppressLint("NotifyDataSetChanged")
    fun setData(d: List<UserItem>) {
        this.data.clear()
        this.data.addAll(d)
        notifyDataSetChanged()
    }

    var onItemClick: ((UserItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapterHolder =
        UserAdapterHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UserAdapterHolder, position: Int) {
        holder.bindData(data = data[position])

        holder.binding.deleteBtn.setOnClickListener {
            onItemClick?.invoke(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    fun itemRemoved(position: Int) {
        this.data.removeAt(position)
        notifyItemRemoved(position)
    }

}