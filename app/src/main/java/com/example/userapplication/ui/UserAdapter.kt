package com.example.userapplication.ui

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userapplication.R
import com.example.userapplication.data.model.UserModel
import com.example.userapplication.databinding.RecyclerRowBinding



class UserAdapter(
    var userList: List<UserModel>
) : ListAdapter<UserModel, UserAdapter.UserViewHolder>(DiffCallBack) {



    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    class UserViewHolder(private val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserModel) {
            Glide.with(binding.ivImage.context)
                .load(item.data?.get(0)?.avatar)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivImage)
            binding.tvFirstName.text = item.data?.get(0)?.firstName
        }
    }

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel) =
                oldItem.page == newItem.page

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel) =
                oldItem == newItem
        }
    }
}
