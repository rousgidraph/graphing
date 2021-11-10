package com.example.graphing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.graphing.R
import com.example.graphing.database.LocalDataSource
import com.example.graphing.databinding.ActivityPersonInBinding
import com.example.graphing.models.Sales_person
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class person_in : AppCompatActivity() {

    private lateinit var  binding : ActivityPersonInBinding
    private lateinit var btn_save : Button
    private lateinit var btn_cancel : Button
    private lateinit var _name : TextView
    private lateinit var _branch : TextView


    @Inject lateinit var dataSource : LocalDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonInBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_person_in)
        setContentView(view)
        //initailising
        btn_cancel = binding.btnCancel
        btn_save  = binding.btnSave

        _name = binding.editName
        _branch = binding.editBranch

        btn_save.setOnClickListener {
            save()
        }

        btn_cancel.setOnClickListener {
            to_main()
        }

    }

    private fun save(){
        val name = _name.text.toString()
        val branch = _branch.text.toString()
        if ((name == null) || (name.length < 1 )){
            _name.requestFocus()
            Toast.makeText(this, "Enter name ", Toast.LENGTH_SHORT).show()
            _name.error =" Something here"
            return
        }

        if ((branch == null) || (branch.length < 1 )){
            _branch.requestFocus()
            Toast.makeText(this, "Enter branch ", Toast.LENGTH_SHORT).show()
            _branch.error =" Something here"
            return
        }

        val perp = Sales_person(name, branch)
        dataSource.addSalesPerson(perp)
        Toast.makeText(this, "Saved  successfully", Toast.LENGTH_SHORT).show()
        clear()

    }

    private fun clear(){
        _name.text = ""
        _branch.text = ""
        _name.requestFocus()
    }

    fun to_main(){
        val int = Intent(this,MainActivity::class.java)
        startActivity(int)
    }
}