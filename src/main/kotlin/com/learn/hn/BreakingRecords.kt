package com.learn.hn

fun breakingRecords(scores: Array<Int>): Array<Int> {
    var (min, max) = MutableList(2) {scores[0]}
    var (minChange, maxChange) = MutableList(2) {0}

    for ( i in 1 until  scores.size) {
        if (scores[i] < min) {
            min = scores [i]
            minChange++
        } else if (scores[i] > max) {
            max = scores[i]
            maxChange++
        }
    }
    return arrayOf(maxChange, minChange)
}

fun main() {
    val scores = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val result = breakingRecords(scores)
    println(result.joinToString(" "))
}
