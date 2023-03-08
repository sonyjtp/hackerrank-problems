//https://tinyurl.com/hackernack003
package com.learn.hn

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

fun timeConversion(s: String): String {
    return LocalTime.parse(
        s.uppercase(Locale.getDefault()),
        DateTimeFormatter.ofPattern("hh:mm:ssa")).format(
        DateTimeFormatter.ofPattern("HH:mm:ss"))

}

fun main() {
    println(timeConversion(readln()))
}

