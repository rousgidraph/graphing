package com.example.graphing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.anychart.APIlib
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.example.graphing.database.LocalDataSource
import com.example.graphing.databinding.ActivityGraphsBinding
import com.example.graphing.models.branch_sales
import com.example.graphing.models.person_total_sales
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class graphs : AppCompatActivity() {
    @Inject
    lateinit var dataSource : LocalDataSource
    private lateinit var binding : ActivityGraphsBinding
    private lateinit var _branch : List<branch_sales> //list of the data on the branches from the database
    private lateinit var _persons : List<person_total_sales> //list of the data on the people from the database
    private lateinit var graph_one : AnyChartView
    private lateinit var graph_two : AnyChartView
    private lateinit var graph_three : AnyChartView
    private lateinit var graph_four : AnyChartView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphsBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_graphs)
        setContentView(view)
        //graph_one = binding.graphOne
        //APIlib.getInstance().setActiveAnyChartView(graph_one)
        //graph_two = binding.graphTwo
        //APIlib.getInstance().setActiveAnyChartView(graph_two)
        //graph_three = binding.graphThree
        //APIlib.getInstance().setActiveAnyChartView(graph_three)
        //graph_four = binding.graphFour
        //APIlib.getInstance().setActiveAnyChartView(graph_four)


        fetch_data()
        //dataSource.get_branch_sales { res ->  run { _branch = res}}
        //dataSource.get_person_total_sales { res -> run { _persons = res } }





    }

    fun fetch_data(){
        dataSource.get_branch_sales { res ->
            run {_branch = res
                //Log .i("Data load ", "branch: "+_branch[0].branch)
                load_bar(_branch)
                load_pie(_branch)
                Log.i("branch ", "fetch_data: has loaded")
            }}
        dataSource.get_person_total_sales { res ->
            run {_persons = res
                //Log.i("data load", "perp: "+_persons[0].name)
                load_bar_perp(_persons)
                load_pie_perp(_persons)
                Log.i("branch ", "fetch_data: has loaded")
            }}

        //Toast.makeText(this, "loaded biatch", Toast.LENGTH_SHORT).show()



    }

    fun load_bar(data_branch :List<branch_sales>)
    {
        graph_one = binding.graphOne
        APIlib.getInstance().setActiveAnyChartView(graph_one)

        var carte : Cartesian = AnyChart.column()

        var data_1 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        data_branch.forEach { curr -> run {
            data_1.add(ValueDataEntry(curr.branch,curr.total)) // load the data in the thing
        } }

        carte.data(data_1) // not sure
        //carte.column(data)
        carte.title("Branch perfomance")
        carte.xAxis(0).title("Branch")
        carte.yAxis(0).title("Total sales")

        //APIlib.getInstance().setActiveAnyChartView(graph_one)
        graph_one.setChart(carte)
        Log.i("heathens", "load_bar: ")

    }

    fun load_pie(data_branch :List<branch_sales>)
    {
        graph_two = binding.graphTwo
        APIlib.getInstance().setActiveAnyChartView(graph_two)

        var pie = AnyChart.pie()
        //APIlib.getInstance().setActiveAnyChartView(graph_two)
        var data_2 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        data_branch.forEach { curr -> run {
            data_2.add(ValueDataEntry(curr.branch,curr.total)) // load the data in the thing
        } }

        pie.data(data_2)
        pie.title().enabled(false)
        pie.legend().enabled(false)
        graph_two.setChart(pie)


    }

    fun load_bar_perp(data_perp :List<person_total_sales>)
    {
        graph_three = binding.graphThree
        APIlib.getInstance().setActiveAnyChartView(graph_three)

        var carte : Cartesian = AnyChart.column()
        //APIlib.getInstance().setActiveAnyChartView(graph_three)
        var data_3 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        data_perp.forEach { curr -> run {
            data_3.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }

        carte.data(data_3)
        carte.title("Personal sales")
        carte.xAxis(0).title("Sales Agent")
        carte.yAxis(0).title("Total sales")
        graph_three.setChart(carte)

    }

    fun load_pie_perp(data_perp :List<person_total_sales>)
    {
        graph_four = binding.graphFour
        APIlib.getInstance().setActiveAnyChartView(graph_four)
        var pie = AnyChart.pie()
        //APIlib.getInstance().setActiveAnyChartView(graph_four)
        var data_4 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        data_perp.forEach { curr -> run {
            data_4.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }

        pie.data(data_4)
        pie.title().enabled(false)
        pie.legend().enabled(false)
        graph_four.setChart(pie)

    }

}