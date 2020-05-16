package com.example.phasecalc

import android.util.Log
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Month
import java.util.*
import kotlin.math.abs
import kotlin.math.floor

class Algo {
    var day = (SimpleDateFormat("dd")).format(Date()).toInt()
    var month = (SimpleDateFormat("MM")).format(Date()).toInt()
    var year = (SimpleDateFormat("yyyy")).format(Date()).toInt()
    var todayPhase = 0.toDouble()
    var percent = 0
    var lastNewMoon = Date(2000, 1, 1)
    var nextFullMoon = Date(2000, 1, 1)



    fun simple(): String {
        val lp = 2551443;
        val now = Date(year, month - 1, day, 20, 35, 0);
        val new_moon = Date(1970, 0, 7, 20, 35, 0);
        val phase = ((now.time - new_moon.time)/1000) % lp;
        todayPhase = floor((phase /(24*3600)).toDouble()) + 1
        return (floor((phase /(24*3600)).toDouble()) + 1).toInt().toString();
    }
    fun conway(): String {
        var r: Double = (year % 100).toDouble()
        r %= 19
        if (r > 9) {
            r -= 19
        }
        r = r * 11 % 30 + month + day
        if (month < 3) {
            r += 2
        }
        if (year < 2000)
        {r -= 4}
        else
        {
            r -= 8.3
        }
        r = Math.floor(r + 0.5) % 30
        if (r < 0)
        {
            todayPhase = r + 30
            return (r + 30).toInt().toString()
        }
        else
        {
            todayPhase = r
            return r.toInt().toString()
        }

    }
    fun trig1(): String {
        if (year < 0) { year++; }
        var jy = year;
        var oldJ = (0).toDouble()
        var jm = month + 1;
        if (month <= 2) {
            jy--; jm += 12; }
        var jul = Math.floor(365.25 * jy) + Math.floor(30.6001 * jm) + day + 1720995;
        if (day + 31 * (month + 12 * year) >= (15 + 31 * (10 + 12 * 1582))) {
            var ja = Math.floor(0.01 * jy);
            jul = jul + 2 - ja + Math.floor(0.25 * ja);
        }
            val thisJD = jul
            val degToRad = 3.14159265 / 180
            var K0 = Math.floor((year - 1900) * 12.3685)
            var T = (year - 1899.5) / 100
            var T2 = T * T
            var T3 = T * T * T
            var J0 = 2415020 + 29 * K0
            var F0 =
                0.0001178 * T2 - 0.000000155 * T3 + (0.75933 + 0.53058868 * K0) - (0.000837 * T + 0.000335 * T2)

            var Frac1 = ((K0 * 0.0808482113) - Math.floor(K0 * 0.0808482113))
            var Frac2 = ((K0 * 0.07171366128) - Math.floor(K0 * 0.07171366128))
            var Frac3 = ((K0 * 0.08519585128) - Math.floor(K0 * 0.08519585128))

            var M0 = 360 * Frac1 + 359.2242 - 0.0000333 * T2 - 0.00000347 * T3
            var M1 = 360 * Frac2 + 306.0253 + 0.0107306 * T2 + 0.00001236 * T3
            var B1 = 360 * Frac3 + 21.2964 - 0.0016528 * T2 - 0.00000239 * T3
            var phase = 0
            var jday = 0.toDouble()
            while (jday < thisJD) {
                var F = F0 + 1.530588 * phase
                val M5 = (M0 + phase * 29.10535608) * degToRad
                val M6 = (M1 + phase * 385.81691806) * degToRad
                val B6 = (B1 + phase * 390.67050646) * degToRad
                F -= 0.4068 * Math.sin(M6) + (0.1734 - 0.000393 * T) * Math.sin(
                    M5
                )
                F += 0.0161 * Math.sin(2 * M6.toDouble()) + 0.0104 * Math.sin(2 * B6.toDouble())
                F -= 0.0074 * Math.sin(M5 - M6.toDouble()) - 0.0051 * Math.sin(
                    M5 + M6.toDouble()
                )
                F += 0.0021 * Math.sin(2 * M5.toDouble()) + 0.0010 * Math.sin(2 * B6 - M6.toDouble())
                F += 0.5 / 1440
                oldJ = jday
                jday = J0 + 28 * phase + Math.floor(F)
                phase++
            }

        todayPhase = (thisJD - oldJ) % 30
        return ((thisJD - oldJ) % 30).toInt().toString()

    }
    fun trig2(): String {
        if (year < 0) { year++; }
        var jy = year;
        var oldJ = (0).toDouble()
        var jm = month + 1;
        if (month <= 2) {
            jy--; jm += 12; }
        var j1 = Math.floor(365.25 * jy) + Math.floor(30.6001 * jm) + day + 1720995;
        if (day + 31 * (month + 12 * year) >= (15 + 31 * (10 + 12 * 1582))) {
            var ja = Math.floor(0.01 * jy);
            j1 = j1 + 2 - ja + Math.floor(0.25 * ja);
        }

        val n = Math.floor(12.37 * (year - 1900 + (1.0 * month - 0.5) / 12.0))
        val RAD = 3.14159265 / 180.0
        val t = n / 1236.85
        val t2 = t * t
        val as1 = 359.2242 + 29.105356 * n
        val am = 306.0253 + 385.816918 * n + 0.010730 * t2
        var xtra = 0.75933 + 1.53058868 * n + (1.178e-4 - 1.55e-7 * t) * t2
        xtra += (0.1734 - 3.93e-4 * t) * Math.sin(RAD * as1) - 0.4068 * Math.sin(
            RAD * am
        )
        val i = if (xtra > 0.0) Math.floor(xtra) else Math.ceil(xtra - 1.0)
        val jd = 2415020 + 28 * n + i
        todayPhase = (j1 - jd + 30) % 30
        return ((j1 - jd + 30) % 30).toInt().toString()
    }
    fun calcNewMoon(): Date {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -todayPhase.toInt())
        calendar.set(Calendar.HOUR, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        lastNewMoon = calendar.time
        return calendar.time
    }
    fun calcFullMoon(): Date {
        val calendar = Calendar.getInstance()
        if (15-todayPhase.toInt() > 0){
            calendar.add(Calendar.DATE, (15-todayPhase.toInt()))
            calendar.set(Calendar.HOUR, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            nextFullMoon = calendar.time
        }
        else {
            var helper = abs(30-todayPhase.toInt()+15)
            calendar.add(Calendar.DATE, helper)
            calendar.set(Calendar.HOUR, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            nextFullMoon = calendar.time
        }

        return calendar.time
    }
    fun calcPercent(): Int {
        percent = ((todayPhase/30)*100).toInt()
        return percent
    }
}