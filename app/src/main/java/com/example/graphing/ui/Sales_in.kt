package com.example.graphing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.graphing.R
import com.example.graphing.database.LocalDataSource
import com.example.graphing.databinding.ActivityPersonInBinding
import com.example.graphing.databinding.ActivitySalesInBinding
import com.example.graphing.models.Sales_person
import javax.inject.Inject

class Sales_in : AppCompatActivity() {
    private lateinit var  binding : ActivitySalesInBinding
    private lateinit var btn_save : Button
    private lateinit var btn_cancel : Button
    private lateinit var spinner : Spinner
    private lateinit var _ammount : TextView

    @Inject
    lateinit var dataSource : LocalDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesInBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_sales_in)
        setContentView(view)

        btn_cancel = binding.btnCancel
        btn_save = binding.btnSave
        spinner = binding.personPicker
        _ammount = binding.saleAmmount



    }

    fun loadSpinner ( peeps : List<Sales_person>){


    }


}