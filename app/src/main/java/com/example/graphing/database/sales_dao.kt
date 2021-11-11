package com.example.graphing.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.graphing.models.PersonWithSales
import com.example.graphing.models.Sale
import com.example.graphing.models.branch_sales

@Dao
interface sales_dao : BaseDao<Sale>{
    /**
     *Simply by extending that base dao all the data can be sent and read from the database
     */

    @Query("select * from branch_sales")
    fun get_brach_details():branch_sales







}