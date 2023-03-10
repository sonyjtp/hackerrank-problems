//https://tinyurl.com/hackernack006
package com.learn.hn


fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var result = 0
    var i = 0
    while (i < n) {
        result += ar.sliceArray(i+1 until n).count { (ar[i] + it) % k == 0 }
        i++
    }
    return result
}

fun main() {
    val input = readln().trimEnd().split(" ")
    print(divisibleSumPairs(input[0].toInt(), input[1].toInt(),
        readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()))
}
