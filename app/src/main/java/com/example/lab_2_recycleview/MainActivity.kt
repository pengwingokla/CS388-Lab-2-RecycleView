package com.example.lab_2_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_2_recycleview.Email
import com.example.lab_2_recycleview.EmailAdapter
import com.example.lab_2_recycleview.EmailFetcher

import android.view.View



class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EmailAdapter
    private var emailList: MutableList<Email> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.emailRecyclerVIew)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        emailList.addAll(EmailFetcher.getEmails()) // Generate an initial list of emails
        adapter = EmailAdapter(emailList)
        recyclerView.adapter = adapter

    }

    fun newEmail(view: View) {
        // This function loads 5 more emails and add them to the existing list
        val startIndex = emailList.size
        val endIndex = startIndex + 1
        val newEmails = EmailFetcher.getNext5Emails()
        emailList.addAll(newEmails)
        adapter.notifyDataSetChanged()

    }

}
