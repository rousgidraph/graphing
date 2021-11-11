package com.example.graphing.models

import androidx.room.DatabaseView


@DatabaseView("select  person_id, name,  SUM(ammount)'total' \n" +
        "from sales_person,sale\n" +
        "where salesPerson_id = person_id\n" +
        "GROUP By person_id")
data class person_total_sales (
    var person_id : Long ,
    var name : String ,
    var total : Double
        )