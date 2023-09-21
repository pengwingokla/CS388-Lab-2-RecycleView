package com.example.lab_2_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmailAdapter(private val itemList: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.emailSubjectView)
        val senderTextView: TextView = itemView.findViewById(R.id.senderNameView)
        val messageView: TextView = itemView.findViewById(R.id.messageView)
        val timeTextView: TextView = itemView.findViewById(R.id.emailTimeView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout from XML and return a new ViewHolder
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.email_preview, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind the data to the views in the ViewHolder
        val item = itemList[position]
        holder.subjectTextView.text = item.subject
        holder.senderTextView.text = item.sender
        holder.timeTextView.text = item.time
        holder.messageView.text = item.message
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
