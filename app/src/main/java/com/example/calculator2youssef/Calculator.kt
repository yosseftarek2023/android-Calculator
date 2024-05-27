package com.example.calculator2youssef

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    modifier:Modifier = Modifier,
    buttonSpace : Dp = 8.dp,
    onAction : (CalculationEvent) -> Unit
){
    val scroll = rememberScrollState(0)
    Box(modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(buttonSpace)
        ) {
                Text(
                    text = state.num1 + (state.op?.op ?: "") + state.num2,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(32.dp).height(150.dp).verticalScroll(scroll),
                    fontWeight = FontWeight.Bold,
                    fontSize = 80.sp,
                    color = Color.Black,
                    lineHeight = 70.sp,
                )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    text = "AC",
                    onClick = { onAction(CalculationEvent.Clear) },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .weight(2f)
                        .aspectRatio(2f)
                )
                CalculatorButton(
                    text = "DEL",
                    onClick = { onAction(CalculationEvent.Delete) },
                    modifier = Modifier
                        .background(Color.LightGray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "/",
                    onClick = { onAction(CalculationEvent.Operation(CalculatorOperator.Divide)) },
                    modifier = Modifier
                        .background(Color.Yellow)
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    text = "7",
                    onClick = { onAction(CalculationEvent.Number(7)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "8",
                    onClick = { onAction(CalculationEvent.Number(8)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "9",
                    onClick = { onAction(CalculationEvent.Number(9)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "*",
                    onClick = { onAction(CalculationEvent.Operation(CalculatorOperator.Multiply)) },
                    modifier = Modifier
                        .background(Color.Yellow)
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    text = "4",
                    onClick = { onAction(CalculationEvent.Number(4)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "5",
                    onClick = { onAction(CalculationEvent.Number(5)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "6",
                    onClick = { onAction(CalculationEvent.Number(6)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "+",
                    onClick = { onAction(CalculationEvent.Operation(CalculatorOperator.Add)) },
                    modifier = Modifier
                        .background(Color.Yellow)
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    text = "1",
                    onClick = { onAction(CalculationEvent.Number(1)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "2",
                    onClick = { onAction(CalculationEvent.Number(2)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "3",
                    onClick = { onAction(CalculationEvent.Number(3)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "-",
                    onClick = { onAction(CalculationEvent.Operation(CalculatorOperator.Subtract)) },
                    modifier = Modifier
                        .background(Color.Yellow)
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {
                CalculatorButton(
                    text = "0",
                    onClick = { onAction(CalculationEvent.Number(0)) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(2f)
                        .aspectRatio(2f)
                )
                CalculatorButton(
                    text = ".",
                    onClick = { onAction(CalculationEvent.Decimal) },
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f)
                        .aspectRatio(1f)
                )
                CalculatorButton(
                    text = "=",
                    onClick = { onAction(CalculationEvent.Calculate) },
                    modifier = Modifier
                        .background(Color.Yellow)
                        .weight(1f)
                        .aspectRatio(1f)
                )
            }
        }
    }
}