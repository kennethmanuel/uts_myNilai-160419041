package com.kennethmanuel.mynilai_160419041

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabTambahMatkul.setOnClickListener{
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        val lm:LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MatkulAdapter(applicationContext)
    }
}