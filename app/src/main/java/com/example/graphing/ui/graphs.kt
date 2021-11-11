package com.example.graphing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.graphing.R
import com.example.graphing.database.LocalDataSource
import com.example.graphing.databinding.ActivityGraphsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class graphs : AppCompatActivity() {
    @Inject
    lateinit var dataSource : LocalDataSource
    private lateinit var binding : ActivityGraphsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphsBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_graphs)
        setContentView(view)
    }

    fun load_bar(){}

    fun load_pie(){}


}