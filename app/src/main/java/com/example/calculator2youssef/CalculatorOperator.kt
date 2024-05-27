package com.example.calculator2youssef

sealed class CalculatorOperator(val op:String) {

    data object Add: CalculatorOperator("+")
    data object Subtract: CalculatorOperator("-")
    data object Multiply: CalculatorOperator("*")
    data object Divide: CalculatorOperator("/")
}