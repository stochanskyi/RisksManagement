package com.mars.risksmanagement.utils

fun<T> MutableList<T>.clearAndAdd(items: List<T>) {
    clear()
    addAll(items)
}