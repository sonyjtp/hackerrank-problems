//https://tinyurl.com/hackernack002
package com.learn.hn

import kotlin.math.floor

fun miniMaxSum(arr: Array<Int>) {
    mergeSort(arr)
    arr.forEach(::println)
    println("${arr.sliceArray((0..3)).sum()} " +
            "${arr.sliceArray((arr.size - 4 until arr.size)).sumOf { it.toLong() }}")
}

private fun mergeSort(nums: Array<Int>) {
    if (nums.size > 1) {
        val mid = floor((nums.size / 2.0)).toInt()
        val left = nums.sliceArray((0 until mid))
        val right = nums.sliceArray((mid until nums.size))
        mergeSort(left)
        mergeSort(right)
        var (i, j, k) = listOf(0, 0, 0)
        while (i < left.size && j < right.size) nums[k++] = if (left[i] < right[j]) left[i++] else right[j++]
        while (i < left.size) nums[k++] = left[i++]
        while (j < right.size) nums[k++] = right[j++]
    }
}

fun main() {
    val arr = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    miniMaxSum(arr)
}

