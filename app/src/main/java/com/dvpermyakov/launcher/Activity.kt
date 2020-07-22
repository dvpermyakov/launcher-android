package com.dvpermyakov.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class Activity : AppCompatActivity() {

    private val adapter = ApplicationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.items = listOf(
            ApplicationItem("1"),
            ApplicationItem("2"),
            ApplicationItem("3"),
            ApplicationItem("4")
        )
    }

}