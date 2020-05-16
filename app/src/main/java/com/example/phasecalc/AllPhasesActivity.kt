package com.example.phasecalc

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.Calendar.*


class AllPhasesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_phases)

        val button40 = findViewById<Button>(R.id.button40)

        button40.setOnClickListener {
            var fullMoons = mutableListOf<Date>()
            var EditText = findViewById<EditText>(R.id.editText);
            var localYear = EditText.getText().toString().toInt()
            var cal = getInstance()
            var endOfYear = getInstance()
            cal.set(localYear + 0, 1, 1)
            endOfYear.set(localYear + 1, 1, 1)
            cal.set(Calendar.HOUR, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)

            for (i in 0..400) {
                var date = Algo()
                date.day = cal.get(DAY_OF_MONTH);
                date.month = cal.get(MONTH);
                date.year = localYear
                var day = ""
                val sharedPreferences = getSharedPreferences("IDvalue", 0)
                val str = sharedPreferences.getString("algorithm", "")

                if (str == "simple") {
                    day = date.simple()
                }
                else if (str == "conway") {

                    day = date.conway()
                }
                else if (str == "trig1") {
                    day = date.trig1()
                }
                else if (str == "trig2") {
                    day = date.trig2()

                }
                else {
                    day = date.trig1()
                }
                if (day == "15" && cal.before(endOfYear)) {
                    fullMoons.add(cal.time)
                }

                cal.add(DATE, 1)
            }

            Log.d("TAG", fullMoons.toString())

            var arrayAdapter: ArrayAdapter<*>
            var dates = fullMoons
            var mListView = findViewById<ListView>(R.id.ListView1)
            arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dates)
            mListView.adapter = arrayAdapter
        }

    }

    override fun onRestart() {
        super.onRestart()
        val button40 = findViewById<Button>(R.id.button40)

        button40.setOnClickListener {
            var fullMoons = mutableListOf<Date>()
            var EditText = findViewById<EditText>(R.id.editText);
            var localYear = EditText.getText().toString().toInt()
            var cal = getInstance()
            var endOfYear = getInstance()
            cal.set(localYear + 0, 1, 1, 0, 0, 0)
            endOfYear.set(localYear + 1, 2, 1, 0, 0, 0)

            val sharedPreferences = getSharedPreferences("IDvalue", 0)
            val str = sharedPreferences.getString("algorithm", "")
            //Log.d("SPppppppppPPPPPppppPPPP", str)

            for (i in 0..500) {
                var date = Algo()
                cal.set(Calendar.HOUR, 0)
                cal.set(Calendar.MINUTE, 0)
                cal.set(Calendar.SECOND, 0)
                date.day = cal.get(DAY_OF_MONTH);
                date.month = cal.get(MONTH);
                date.year = localYear
                //Log.d("dddddday", date.day.toString())
                var day = ""
                if (str == "simple") {
                    day = date.simple()
                }
                else if (str == "conway") {
                    day = date.conway()
                }
                else if (str == "trig1") {
                    day = date.trig1()
                }
                else if (str == "trig2") {
                    day = date.trig2()

                } else {
                    day = date.trig1()
                }
                if (day == "15" && cal.before(endOfYear)) {
                    cal.set(Calendar.HOUR, 0)
                    cal.set(Calendar.MINUTE, 0)
                    cal.set(Calendar.SECOND, 0)
                    fullMoons.add(cal.time)
                }

                cal.add(DAY_OF_MONTH, 1)
                Log.d("TAG", cal.get(DAY_OF_MONTH).toString())
            }

            //Log.d("TAG", fullMoons.toString())

            var arrayAdapter: ArrayAdapter<*>
            var dates = fullMoons
            var mListView = findViewById<ListView>(R.id.ListView1)
            arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dates)
            mListView.adapter = arrayAdapter

        }
    }
}