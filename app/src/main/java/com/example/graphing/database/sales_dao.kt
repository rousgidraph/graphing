package com.example.graphing.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.graphing.models.PersonWithSales
import com.example.graphing.models.Sale
import com.example.graphing.models.branch_sales
import com.example.graphing.models.person_total_sales

@Dao
interface sales_dao : BaseDao<Sale>{
    /**
     *Simply by extending that base dao all the data can be sent and read from the database
     */

    @Transaction
    @Query("select * from branch_sales")
    fun get_brach_sales():List<branch_sales>


    @Transaction
    @Query("Select * from person_total_sales")
    fun get_person_total_sale(): List<person_total_sales>







}