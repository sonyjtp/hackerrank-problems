//https://tinyurl.com/hackernack004
package com.learn.hn

import java.util.*

fun main() {
    val lines = generateSequence(::readln)
    for (line in lines) {
        if (line.isEmpty()) break
        convert(line.split(";"))
    }
}

private fun convert(input: List<String>) {
    println(when (input[0]) {
        "S" -> splitWords(input[1], input[2])
        "C" -> combineWords(input[1], input[2])
        else -> throw IllegalArgumentException("Invalid input")
    })
}

private fun splitWords(type: String, word: String): String = word.let {
    if ("M".equals(type, true)) it.substringBefore('(') else it
}.let {
    val chars = mutableListOf<String>()
    for(chr in it.toCharArray()) {
        if(chr.isUpperCase() && it.indexOf(chr) != 0) chars.add(" ")
        chars.add(chr.toString().lowercase(Locale.getDefault()))
    }
    chars
}.joinToString("")

private fun combineWords(type: String, words: String): String  = words.let {
    val firstSplit = it.substringBefore(" ")
    val splits = if(it.indexOf(" ") > -1) it.substringAfter(" ").split(" ") else mutableListOf()
    return when(type) {
        "V" -> firstSplit + if (splits.isEmpty()) "" else splits.joinToString("") { word ->
            word.replaceFirstChar {
                    first -> if (first.isLowerCase()) first.titlecase(Locale.getDefault()) else first.toString() }
        }
        "C" -> firstSplit.replaceFirstChar {
                    first -> if (first.isLowerCase()) first.titlecase(Locale.getDefault()) else first.toString() } +
                splits.joinToString("") { word ->
                    word.replaceFirstChar {
                    first -> if (first.isLowerCase()) first.titlecase(Locale.getDefault()) else first.toString() }
                }

        "M" -> firstSplit + splits.joinToString("") { word ->
            word.replaceFirstChar {
                    first -> if (first.isLowerCase()) first.titlecase(Locale.getDefault()) else first.toString() }
        } + "()"
        else -> throw IllegalArgumentException("Invalid input")
    }
}

