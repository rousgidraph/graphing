package com.example.graphing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.graphing.models.Sale
import com.example.graphing.models.Sales_person
import com.example.graphing.models.branch_sales
import com.example.graphing.models.person_total_sales

@Database(entities = arrayOf(Sale::class,Sales_person::class),
    views = arrayOf(branch_sales::class,person_total_sales::class),
    version = 1,
    exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun SalesPersonDao() : SalesPersonDao
    abstract fun sales_dao(): sales_dao
}