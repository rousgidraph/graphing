package com.example.graphing.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.graphing.models.PersonWithSales
import com.example.graphing.models.Sales_person

@Dao
interface SalesPersonDao : BaseDao<Sales_person> {
    /**
     * extending the base dao ensures all the read write methods are implemented
     */

    @Transaction
    @Query("Select * from Sales_person")
    fun getPersonWithSales(): List<PersonWithSales>


    @Transaction // any query with a select statement will run in a transaction
    @Query("Select * from Sales_person")
    fun getall(): List<Sales_person>

    @Transaction
    @Query("Select * from Sales_person where person_id like :searchQuery")
    fun getSalesPerson(searchQuery: Long): Sales_person


}