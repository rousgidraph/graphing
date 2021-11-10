package com.example.graphing.models

import androidx.room.Embedded
import androidx.room.Relation

data class PersonWithSales (
    @Embedded val salesPerson: Sales_person,
    @Relation(
        parentColumn = "person_id",
        entityColumn = "salesPerson_id"
    )
    val sales : List<Sale>
    ){
}