package com.example.toyproject013_carrotmarket.chatList


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject013_carrotmarket.databinding.ItemArticleBinding
import com.example.toyproject013_carrotmarket.databinding.ItemChatListBinding
import com.example.toyproject013_carrotmarket.home.ArticleModel
import java.text.SimpleDateFormat
import java.util.*

class ChatListAdapter(val onItemClickd: (ChatListItem) -> Unit) : ListAdapter<ChatListItem, ChatListAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: ItemChatListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(chatListItem: ChatListItem) {

            binding.root.setOnClickListener {
                onItemClickd(chatListItem)
            }

            binding.chatRoomTitleTextView.text = chatListItem.itemTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChatListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChatListItem>() {
            override fun areItemsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                return oldItem.key == newItem.key
            }

            override fun areContentsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}