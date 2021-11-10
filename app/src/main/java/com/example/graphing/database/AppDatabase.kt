package com.example.graphing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.graphing.models.Sale
import com.example.graphing.models.Sales_person

@Database(entities = arrayOf(Sale::class,Sales_person::class), version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun SalesPersonDao() : SalesPersonDao
    abstract fun sales_dao(): sales_dao
}