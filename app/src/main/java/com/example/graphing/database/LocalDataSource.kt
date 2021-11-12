package com.example.graphing.database

import android.os.Looper
import android.os.Handler
import androidx.activity.OnBackPressedCallback
import com.example.graphing.models.*
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import javax.inject.Inject

class LocalDataSource @Inject
constructor(private val salesPersonDao: SalesPersonDao,
            private val salesDao: sales_dao) {
    private val executorService : ExecutorService = Executors.newFixedThreadPool(5)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun addSalesPerson(person: Sales_person){
        executorService.execute{
            salesPersonDao.insert(person)
        }
    }

    fun addSales(sale : Sale){
        executorService.execute{
            salesDao.insert(sale)
        }
    }

    fun getPerson_sales(callback: (List<PersonWithSales>) -> Unit){
        executorService.execute { // this ensure no heavy access happens on the main thread
            val returnable = salesPersonDao.getPersonWithSales()
            mainThreadHandler.post { callback(returnable) }
        }
    }

    fun getSales_person(persons_id : Long ){
        salesPersonDao.getSalesPerson(persons_id)

    }

    fun getSales_persons(callback: (List<Sales_person>) -> Unit){
        executorService.execute {
            val returnable = salesPersonDao.getall()
            mainThreadHandler.post{callback(returnable)}
        }


    }

    fun get_person_total_sales(callback: (List<person_total_sales>) -> Unit ){
        executorService.execute{
            val returnable = salesDao.get_person_total_sale()
            mainThreadHandler.post{callback(returnable)}
        }
    }

    fun get_branch_sales(callback: (List<branch_sales>) -> Unit){
        executorService.execute {
            val returnable = salesDao.get_brach_sales()
            mainThreadHandler.post { callback(returnable) }
        }
    }


}