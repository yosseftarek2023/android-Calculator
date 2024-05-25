package com.example.calculatoryoussef

sealed class CalculationEvent {
    data class Number(val num:Int):CalculationEvent()
    object Delete: CalculationEvent()
    object Clear:CalculationEvent()
    object Calculate:CalculationEvent()
    object Decimal:CalculationEvent()
    data class Operation(val op:CalculatorOperator):CalculationEvent()

}