package com.example.phasecalc
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val date = Algo()
        this.textView6.text = date.trig1();
        this.textView7.text = (date.calcPercent().toString()+"%");
        val helper = date.calcPercent()
        this.textView8.text = (date.calcNewMoon()).toString()
        this.textView9.text = (date.calcFullMoon().toString())

        val image= findViewById<ImageView>(R.id.imageView2)
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, AllPhasesActivity::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.button11)
        button2.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("IDvalue", 0)
        val side = sharedPreferences.getString("side", "")

        if (helper < 3 && side =="p"){
            image.setImageResource(R.drawable.n1)
        }
        else if (helper < 7 && side =="p") {
            image.setImageResource(R.drawable.n2)
        }
        else if (helper < 11 && side =="p") {
            image.setImageResource(R.drawable.n3)
        }
        else if (helper < 14 && side =="p") {
            image.setImageResource(R.drawable.n4)
        }
        else if (helper < 17 && side =="p") {
            image.setImageResource(R.drawable.n5)
        }
        else if (helper < 20 && side =="p") {
            image.setImageResource(R.drawable.n6)
        }
        else if (helper < 23 && side =="p") {
            image.setImageResource(R.drawable.n7)
        }
        else if (helper < 27 && side =="p") {
            image.setImageResource(R.drawable.n8)
        }
        else if (helper < 30 && side =="p") {
            image.setImageResource(R.drawable.n9)
        }
        else if (helper < 33 && side =="p") {
            image.setImageResource(R.drawable.n10aa)
        }
        else if (helper < 36 && side =="p") {
            image.setImageResource(R.drawable.n10bb)
        }
        else if (helper < 39 && side =="p") {
            image.setImageResource(R.drawable.n11)
        }
        else if (helper < 42 && side =="p") {
            image.setImageResource(R.drawable.n12)
        }
        else if (helper < 46 && side =="p") {
            image.setImageResource(R.drawable.n13)
        }
        else if (helper < 50 && side =="p") {
            image.setImageResource(R.drawable.n14)
        }
        else if (helper < 54 && side =="p") {
            image.setImageResource(R.drawable.n15)
        }
        else if (helper < 57 && side =="p") {
            image.setImageResource(R.drawable.n16)
        }
        else if (helper < 60 && side =="p") {
            image.setImageResource(R.drawable.n17)
        }
        else if (helper < 63 && side =="p") {
            image.setImageResource(R.drawable.n18)
        }
        else if (helper < 67 && side =="p") {
            image.setImageResource(R.drawable.n19)
        }
        else if (helper < 70 && side =="p") {
            image.setImageResource(R.drawable.n20)
        }
        else if (helper < 73 && side =="p") {
            image.setImageResource(R.drawable.n21)
        }
        else if (helper < 76 && side =="p") {
            image.setImageResource(R.drawable.n22)
        }
        else if (helper < 80 && side =="p") {
            image.setImageResource(R.drawable.n23)
        }
        else if (helper < 84 && side =="p") {
            image.setImageResource(R.drawable.n24)
        }
        else if (helper < 87 && side =="p") {
            image.setImageResource(R.drawable.n25)
        }
        else if (helper < 90 && side =="p") {
            image.setImageResource(R.drawable.n26)
        }
        else if (helper < 93 && side =="p") {
            image.setImageResource(R.drawable.n27)
        }
        else if (helper < 96 && side =="p") {
            image.setImageResource(R.drawable.n28)
        }
        else if (helper <= 100 && side =="p") {
            image.setImageResource(R.drawable.nn29)
        }



        if (helper < 3 && side =="d"){
            image.setImageResource(R.drawable.s1)
        }
        else if (helper < 7 && side =="d") {
            image.setImageResource(R.drawable.s2)
        }
        else if (helper < 11 && side =="d") {
            image.setImageResource(R.drawable.s3)
        }
        else if (helper < 14 && side =="d") {
            image.setImageResource(R.drawable.s4)
        }
        else if (helper < 17 && side =="d") {
            image.setImageResource(R.drawable.s5)
        }
        else if (helper < 20 && side =="d") {
            image.setImageResource(R.drawable.s6)
        }
        else if (helper < 23 && side =="d") {
            image.setImageResource(R.drawable.s7)
        }
        else if (helper < 27 && side =="d") {
            image.setImageResource(R.drawable.s8)
        }
        else if (helper < 30 && side =="d") {
            image.setImageResource(R.drawable.s9)
        }
        else if (helper < 33 && side =="d") {
            image.setImageResource(R.drawable.s10)
        }
        else if (helper < 36 && side =="d") {
            image.setImageResource(R.drawable.s11)
        }
        else if (helper < 39 && side =="d") {
            image.setImageResource(R.drawable.s12)
        }
        else if (helper < 42 && side =="d") {
            image.setImageResource(R.drawable.s13)
        }
        else if (helper < 46 && side =="d") {
            image.setImageResource(R.drawable.s14)
        }
        else if (helper < 50 && side =="d") {
            image.setImageResource(R.drawable.s15)
        }
        else if (helper < 54 && side =="d") {
            image.setImageResource(R.drawable.s16)
        }
        else if (helper < 57 && side =="d") {
            image.setImageResource(R.drawable.s17)
        }
        else if (helper < 60 && side =="d") {
            image.setImageResource(R.drawable.s18)
        }
        else if (helper < 63 && side =="d") {
            image.setImageResource(R.drawable.s19)
        }
        else if (helper < 67 && side =="d") {
            image.setImageResource(R.drawable.s20)
        }
        else if (helper < 70 && side =="d") {
            image.setImageResource(R.drawable.s21)
        }
        else if (helper < 73 && side =="d") {
            image.setImageResource(R.drawable.s22)
        }
        else if (helper < 76 && side =="d") {
            image.setImageResource(R.drawable.s23)
        }
        else if (helper < 80 && side =="d") {
            image.setImageResource(R.drawable.s24)
        }
        else if (helper < 84 && side =="d") {
            image.setImageResource(R.drawable.s25)
        }
        else if (helper < 87 && side =="d") {
            image.setImageResource(R.drawable.s26)
        }
        else if (helper < 90 && side =="d") {
            image.setImageResource(R.drawable.s27)
        }
        else if (helper < 93 && side =="d") {
            image.setImageResource(R.drawable.s28)
        }
        else if (helper < 96 && side =="d") {
            image.setImageResource(R.drawable.s29)
        }
        else if (helper <= 100 && side =="d") {
            image.setImageResource(R.drawable.s30)
        }


    }

    override fun onRestart() {
        super.onRestart()
        val date = Algo()
        val sharedPreferences = getSharedPreferences("IDvalue", 0)
        val str = sharedPreferences.getString("algorithm", "")
//        Log.d("SP", str)
        if (str == "simple")
        {
            this.textView6.text = date.simple();
            this.textView7.text = (date.calcPercent().toString()+"%")
            val helper = date.calcPercent()
            this.textView8.text = (date.calcNewMoon()).toString()
            this.textView9.text = (date.calcFullMoon().toString())
        }
        if (str == "conway")
        {
            this.textView6.text = date.conway();
            this.textView7.text = (date.calcPercent().toString()+"%")
            val helper = date.calcPercent()
            this.textView8.text = (date.calcNewMoon()).toString()
            this.textView9.text = (date.calcFullMoon().toString())
        }
        if (str == "trig1")
        {
            this.textView6.text = date.trig1();
            this.textView7.text = (date.calcPercent().toString()+"%")
            val helper = date.calcPercent()
            this.textView8.text = (date.calcNewMoon()).toString()
            this.textView9.text = (date.calcFullMoon().toString())
        }
        if (str == "trig2")
        {
            this.textView6.text = date.trig2();
            this.textView7.text = (date.calcPercent().toString()+"%")
            val helper = date.calcPercent()
            this.textView8.text = (date.calcNewMoon()).toString()
            this.textView9.text = (date.calcFullMoon().toString())
        }

        val helper = date.calcPercent()

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, AllPhasesActivity::class.java)
            startActivity(intent)

        }

        val image= findViewById<ImageView>(R.id.imageView2)
        val side = sharedPreferences.getString("side", "")

        if (helper < 3 && side =="p"){
            image.setImageResource(R.drawable.n1)
        }
        else if (helper < 7 && side =="p") {
            image.setImageResource(R.drawable.n2)
        }
        else if (helper < 11 && side =="p") {
            image.setImageResource(R.drawable.n3)
        }
        else if (helper < 14 && side =="p") {
            image.setImageResource(R.drawable.n4)
        }
        else if (helper < 17 && side =="p") {
            image.setImageResource(R.drawable.n5)
        }
        else if (helper < 20 && side =="p") {
            image.setImageResource(R.drawable.n6)
        }
        else if (helper < 23 && side =="p") {
            image.setImageResource(R.drawable.n7)
        }
        else if (helper < 27 && side =="p") {
            image.setImageResource(R.drawable.n8)
        }
        else if (helper < 30 && side =="p") {
            image.setImageResource(R.drawable.n9)
        }
        else if (helper < 33 && side =="p") {
            image.setImageResource(R.drawable.n10aa)
        }
        else if (helper < 36 && side =="p") {
            image.setImageResource(R.drawable.n10bb)
        }
        else if (helper < 39 && side =="p") {
            image.setImageResource(R.drawable.n11)
        }
        else if (helper < 42 && side =="p") {
            image.setImageResource(R.drawable.n12)
        }
        else if (helper < 46 && side =="p") {
            image.setImageResource(R.drawable.n13)
        }
        else if (helper < 50 && side =="p") {
            image.setImageResource(R.drawable.n14)
        }
        else if (helper < 54 && side =="p") {
            image.setImageResource(R.drawable.n15)
        }
        else if (helper < 57 && side =="p") {
            image.setImageResource(R.drawable.n16)
        }
        else if (helper < 60 && side =="p") {
            image.setImageResource(R.drawable.n17)
        }
        else if (helper < 63 && side =="p") {
            image.setImageResource(R.drawable.n18)
        }
        else if (helper < 67 && side =="p") {
            image.setImageResource(R.drawable.n19)
        }
        else if (helper < 70 && side =="p") {
            image.setImageResource(R.drawable.n20)
        }
        else if (helper < 73 && side =="p") {
            image.setImageResource(R.drawable.n21)
        }
        else if (helper < 76 && side =="p") {
            image.setImageResource(R.drawable.n22)
        }
        else if (helper < 80 && side =="p") {
            image.setImageResource(R.drawable.n23)
        }
        else if (helper < 84 && side =="p") {
            image.setImageResource(R.drawable.n24)
        }
        else if (helper < 87 && side =="p") {
            image.setImageResource(R.drawable.n25)
        }
        else if (helper < 90 && side =="p") {
            image.setImageResource(R.drawable.n26)
        }
        else if (helper < 93 && side =="p") {
            image.setImageResource(R.drawable.n27)
        }
        else if (helper < 96 && side =="p") {
            image.setImageResource(R.drawable.n28)
        }
        else if (helper <= 100 && side =="p") {
            image.setImageResource(R.drawable.nn29)
        }



        if (helper < 3 && side =="d"){
            image.setImageResource(R.drawable.s1)
        }
        else if (helper < 7 && side =="d") {
            image.setImageResource(R.drawable.s2)
        }
        else if (helper < 11 && side =="d") {
            image.setImageResource(R.drawable.s3)
        }
        else if (helper < 14 && side =="d") {
            image.setImageResource(R.drawable.s4)
        }
        else if (helper < 17 && side =="d") {
            image.setImageResource(R.drawable.s5)
        }
        else if (helper < 20 && side =="d") {
            image.setImageResource(R.drawable.s6)
        }
        else if (helper < 23 && side =="d") {
            image.setImageResource(R.drawable.s7)
        }
        else if (helper < 27 && side =="d") {
            image.setImageResource(R.drawable.s8)
        }
        else if (helper < 30 && side =="d") {
            image.setImageResource(R.drawable.s9)
        }
        else if (helper < 33 && side =="d") {
            image.setImageResource(R.drawable.s10)
        }
        else if (helper < 36 && side =="d") {
            image.setImageResource(R.drawable.s11)
        }
        else if (helper < 39 && side =="d") {
            image.setImageResource(R.drawable.s12)
        }
        else if (helper < 42 && side =="d") {
            image.setImageResource(R.drawable.s13)
        }
        else if (helper < 46 && side =="d") {
            image.setImageResource(R.drawable.s14)
        }
        else if (helper < 50 && side =="d") {
            image.setImageResource(R.drawable.s15)
        }
        else if (helper < 54 && side =="d") {
            image.setImageResource(R.drawable.s16)
        }
        else if (helper < 57 && side =="d") {
            image.setImageResource(R.drawable.s17)
        }
        else if (helper < 60 && side =="d") {
            image.setImageResource(R.drawable.s18)
        }
        else if (helper < 63 && side =="d") {
            image.setImageResource(R.drawable.s19)
        }
        else if (helper < 67 && side =="d") {
            image.setImageResource(R.drawable.s20)
        }
        else if (helper < 70 && side =="d") {
            image.setImageResource(R.drawable.s21)
        }
        else if (helper < 73 && side =="d") {
            image.setImageResource(R.drawable.s22)
        }
        else if (helper < 76 && side =="d") {
            image.setImageResource(R.drawable.s23)
        }
        else if (helper < 80 && side =="d") {
            image.setImageResource(R.drawable.s24)
        }
        else if (helper < 84 && side =="d") {
            image.setImageResource(R.drawable.s25)
        }
        else if (helper < 87 && side =="d") {
            image.setImageResource(R.drawable.s26)
        }
        else if (helper < 90 && side =="d") {
            image.setImageResource(R.drawable.s27)
        }
        else if (helper < 93 && side =="d") {
            image.setImageResource(R.drawable.s28)
        }
        else if (helper < 96 && side =="d") {
            image.setImageResource(R.drawable.s29)
        }
        else if (helper <= 100 && side =="d") {
            image.setImageResource(R.drawable.s30)
        }

    }
}