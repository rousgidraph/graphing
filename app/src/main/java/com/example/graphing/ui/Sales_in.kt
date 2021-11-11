package com.example.graphing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.graphing.R
import com.example.graphing.database.LocalDataSource
import com.example.graphing.databinding.ActivityPersonInBinding
import com.example.graphing.databinding.ActivitySalesInBinding
import com.example.graphing.models.Sale
import com.example.graphing.models.Sales_person
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Sales_in : AppCompatActivity() {
    private lateinit var  binding : ActivitySalesInBinding
    private lateinit var btn_save : Button
    private lateinit var btn_cancel : Button
    private lateinit var spinner : Spinner
    private lateinit var _ammount : TextView
    private lateinit var  selected : Sales_person
    private lateinit var person_list : List<Sales_person>

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

        dataSource.getSales_persons { perps -> run {
            person_list = perps ;
            loadSpinner(perps)} }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected = person_list.get(p2)
                Log.i("Get me ", "onItemSelected: "+selected.person_id)



            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btn_save.setOnClickListener {
            save()
        }

    }

    fun loadSpinner ( peeps : List<Sales_person>){
        //Toast.makeText(this, ""+peeps.get(0).name, Toast.LENGTH_SHORT).show()
        var names : MutableList<String> = mutableListOf()
        peeps.forEach { person ->
            names.add(person.name)
        }

        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,names)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun save(){
        if (selected == null){
            spinner.requestFocus()
            Toast.makeText(this, "Select a sales person", Toast.LENGTH_SHORT).show()
        }
        var ammount = _ammount.text.toString().toDoubleOrNull()
        var pesa : Double = 0.0
        if((ammount == null)||(ammount < 1)){
            _ammount.requestFocus()
            Toast.makeText(this, "Enter sale ammount", Toast.LENGTH_SHORT).show()
        }else{
            pesa = ammount.toDouble()
        }

        var _id = selected.person_id


        var temp = Sale(pesa,_id)
        dataSource.addSales(temp)

        _ammount.text  = ""
        spinner.requestFocus()


    }

    fun exit(){
        val int = Intent(this,MainActivity::class.java)
        startActivity(int)
    }




}


