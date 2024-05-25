package com.example.calculatoryoussef

sealed class CalculatorOperator(val op:String) {

    object Add:CalculatorOperator("+")
    object Subtract:CalculatorOperator("-")
    object Multiply:CalculatorOperator("*")
    object Divide:CalculatorOperator("/")
}