package com.example.androidadavacedkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadavacedkotlin.R
import com.example.androidadavacedkotlin.model.TaskModel


/**
 * Created by Eldor Turgunov on 17.06.2022.
 * Android Adavaced Kotlin
 * eldorturgunov777@gmail.com
 */
class TaskAdapter(
    var context: Context,
    var items: ArrayList<TaskModel>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    var onItemClick: ((TaskModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false)
        return ItemViewHolder(view, mListener)
    }

    class ItemViewHolder(view: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(view) {
        var task: TextView? = null
        var title: TextView? = null

        init {
            task = view.findViewById(R.id.tv_tasks)
            title = view.findViewById(R.id.tv_title)
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            (holder as ItemViewHolder).task!!.text = items[position].task
            (holder as ItemViewHolder).title!!.text = items[position].title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}