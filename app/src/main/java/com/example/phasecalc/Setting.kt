package com.example.phasecalc

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity


class Setting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {



        val sharedPreference =  getSharedPreferences("IDvalue", 0)
        var editor = sharedPreference.edit()
        editor.putString("algorithm", "trig1")
        editor.putString("algorithm", "p")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val button3 = findViewById<Button>(R.id.button10)

        button3.setOnClickListener {
            editor.clear()
            if (findViewById<RadioButton>(R.id.simple).isChecked) {
                editor.putString("algorithm", "simple")
            }
            if (findViewById<RadioButton>(R.id.conway).isChecked) {
                editor.putString("algorithm", "conway")
            }
            if (findViewById<RadioButton>(R.id.trig1).isChecked) {
                editor.putString("algorithm", "trig1")
            }
            if (findViewById<RadioButton>(R.id.trig2).isChecked) {
                editor.putString("algorithm", "trig2")
            }
            if (findViewById<RadioButton>(R.id.p).isChecked) {
                editor.putString("side", "p")
            }
            if (findViewById<RadioButton>(R.id.d).isChecked) {
                editor.putString("side", "d")
            }
            editor.apply()
        }
    }
}
