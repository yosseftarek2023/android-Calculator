package com.example.calculator2youssef

sealed class CalculationEvent {
    data class Number(val num:Int): CalculationEvent()
    data object Delete: CalculationEvent()
    data object Clear: CalculationEvent()
    data object Calculate: CalculationEvent()
    data object Decimal: CalculationEvent()
    data class Operation(val op: CalculatorOperator): CalculationEvent()

}