package com.example.graphing.models

import androidx.room.DatabaseView

@DatabaseView("Select branch,  SUM(ammount) 'total'\n" +
        "from Sale,sales_person\n" +
        "where salesPerson_id = person_id\n" +
        "group By branch")
data class branch_sales (
    var branch : String,
    var total : Double
        )