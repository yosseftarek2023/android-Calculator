package com.example.calculator2youssef

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculationEvent){
        when(action){
            is CalculationEvent.Number -> enterNumber(action.num)
            is CalculationEvent.Decimal -> enterDecimal()
            is CalculationEvent.Operation ->enterOperator(action.op)
            is CalculationEvent.Clear -> clearNum()
            is CalculationEvent.Delete -> deleteNum()
            is CalculationEvent.Calculate -> calcFun()

        }
    }

    private fun deleteNum() {
        when{
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )

            state.op != null -> state = state.copy(
                op = null
            )

            state.num1.isNotBlank() -> state = state.copy(
                num1 = state.num1.dropLast(1)
            )
        }
    }
    private fun calcFun() {
        val number1 = state.num1.toDoubleOrNull()
        val number2 = state.num2.toDoubleOrNull()
        if(number2 != null && number1 != null){
            val result = when(state.op){
                is CalculatorOperator.Add -> number1 + number2
                is CalculatorOperator.Multiply -> number1 * number2
                is CalculatorOperator.Subtract -> number1 - number2
                is CalculatorOperator.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(num1 = result.toString()
            , num2 = ""
            ,op = null,
                isResultDisplayed = true)
        }
    }

    private fun clearNum() {
        state = state.copy(num1 = "", num2 = "",op = null,isResultDisplayed = false)
    }

    private fun enterOperator(op: CalculatorOperator) {
        if(state.num1.isNotBlank()){
            state = state.copy(op = op)
        }
    }

    private fun enterDecimal() {
        if(state.op == null && state.num1.isNotBlank() && !state.num1.contains(".")){
            state = state.copy(num1 = state.num1 + ".")
            return
        }
        if(state.num2.isNotBlank() && !state.num2.contains(".")){
            state = state.copy(num2 = state.num2 + ".")
            return
        }
    }

    private fun enterNumber(num: Int) {
        if(state.isResultDisplayed){
            state = state.copy(num1 = num.toString(), num2 = "", op = null, isResultDisplayed = false)
            return
        }

        if(state.op == null){
            if(state.num1.length > 8){
                return
            }
            state = state.copy(num1 = state.num1 + num )
            return
        }
        if(state.num2.length > 8){
            return
        }
        state = state.copy(num2 = state.num2 + num)

    }
}