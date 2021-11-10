package com.example.graphing.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sales_person(val name: String, val branch : String  ) {
    @PrimaryKey(autoGenerate = true)
    var person_id : Long = 0
}