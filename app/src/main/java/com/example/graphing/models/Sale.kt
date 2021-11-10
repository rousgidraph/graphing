package com.example.graphing.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sale( val ammount: Double, val salesPerson_id: Long ) {
    @PrimaryKey(autoGenerate = true)
    var sales_id:Long =0
}