package com.example.kotlincalc

interface Calculator {
    fun add (x: Int, y:Int) = x + y
    fun subtract (x: Int, y:Int) = x - y
    fun multiply (x: Int, y:Int) = x * y
    fun divide (x: Int, y: Int) = x / y
}