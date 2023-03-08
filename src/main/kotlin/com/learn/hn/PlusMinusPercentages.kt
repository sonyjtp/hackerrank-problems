//https://tinyurl.com/hackernack001

package com.learn.hn

private fun plusMinus(arr: Array<Int>) {
    var (pos, neg, zeros) = listOf(0, 0, 0)
    arr.forEach {
        when {
            it > 0 -> pos++
            it < 0 -> neg++
            else -> zeros++
        }
    }
    println("%.6f".format((pos.toDouble()/arr.size)))
    println("%.6f".format((neg.toDouble()/arr.size)))
    println("%.6f".format((zeros.toDouble()/arr.size)))
}

fun main() {
    val arr = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    plusMinus(arr)
}


