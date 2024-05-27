package com.example.calculator2youssef

data class CalculatorState(
    val num1:String ="",
    val num2:String ="",
    val op: CalculatorOperator?= null,
    val isResultDisplayed: Boolean = false
)
