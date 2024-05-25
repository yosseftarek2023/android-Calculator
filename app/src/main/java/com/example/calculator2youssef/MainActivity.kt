package com.example.calculator2youssef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.calculator2youssef.Calculator
import com.example.calculator2youssef.ui.theme.Calculator2YoussefTheme
import com.example.calculatoryoussef.CalculatorViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator2YoussefTheme {
                val viewModel: CalculatorViewModel by viewModels()
                val buttonSpace = 8.dp
                Calculator(state = viewModel.state, onAction = viewModel::onAction,
                    buttonSpace = buttonSpace,
                    modifier = Modifier.fillMaxSize()
                        .background(Color.White)
                        .padding(16.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculator2YoussefTheme {
    }
}