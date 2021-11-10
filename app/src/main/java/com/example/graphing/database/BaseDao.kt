package com.example.graphing.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {
    @Insert
    fun insert(vararg obj:T)

    @Update
    fun update(vararg obj: T)

    @Delete
    fun delete(obj: T)



}