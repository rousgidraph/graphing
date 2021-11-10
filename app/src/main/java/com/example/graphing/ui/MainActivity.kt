package com.example.graphing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.graphing.R
import com.example.graphing.databinding.ActivityMainBinding
import com.example.graphing.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var btn_graphs : Button
    private lateinit var btn_sales : Button
    private lateinit var btn_person : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_main)
        setContentView(view)

        btn_graphs = binding.btnGraph
        btn_person = binding.btnPerson
        btn_sales = binding.btnSale

        btn_sales.setOnClickListener {
            to_sales()
        }

        btn_person.setOnClickListener {
            to_person()
        }

        btn_graphs.setOnClickListener {
            to_graph()
        }


    }

    private fun to_graph(){
        val int = Intent(this, graphs::class.java)
        startActivity(int)

    }
    private fun to_sales(){
        val int = Intent(this, Sales_in::class.java)
        startActivity(int)
    }
    private fun to_person(){
        val int = Intent(this, person_in::class.java)
        startActivity(int)
    }
}