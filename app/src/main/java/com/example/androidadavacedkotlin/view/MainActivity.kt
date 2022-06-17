package com.example.androidadavacedkotlin.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadavacedkotlin.R
import com.example.androidadavacedkotlin.adapter.TaskAdapter
import com.example.androidadavacedkotlin.model.TaskModel


class MainActivity : AppCompatActivity() {
    private var list: ArrayList<TaskModel> = ArrayList()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = TaskAdapter(this, list)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : TaskAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                when (position) {
                    0 -> {
                        val intent = Intent(this@MainActivity, FirstActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    5 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    6 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    7 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    8 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    9 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    10 -> {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
        data()
    }

    fun data() {
        list.add(TaskModel("1", "Dependencies, Localization"))
        list.add(TaskModel("2", "Shared Preferences"))
        list.add(TaskModel("3", "SQL & NoSQL Databases"))
        list.add(TaskModel("4", "Internal & External Storages"))
        list.add(TaskModel("5", "Service, Broadcast Receiver"))
        list.add(TaskModel("6", "Network Request"))
        list.add(TaskModel("7", "Response Parsing"))
        list.add(TaskModel("8", "Firebase Setting, Auth"))
        list.add(TaskModel("9", "Firebase Database"))
        list.add(TaskModel("10", "Firebase Storage"))
    }

}