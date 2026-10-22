package com.example.calculatorapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme // Тема под ваше имя

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              SimpleCalculator() // моя функция

        }
    }
}

@Composable
fun SimpleCalculator() {
    // переменные хранения текста
    var num1Text by remember { mutableStateOf("") }
    var num2Text by remember { mutableStateOf("") }
    var operationText by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    // Вертикальная колонка для всех элементов
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        //  ВВОД
        Row(modifier = Modifier.fillMaxWidth()) {
            // Поле для первого числа
            OutlinedTextField(
                value = num1Text,
                onValueChange = { num1Text = it },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            // Текст для знака операции
            Text(
                text = operationText,
                fontSize = 30.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            // Поле для второго числа
            OutlinedTextField(
                value = num2Text,
                onValueChange = { num2Text = it },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        // результат
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "=", fontSize = 30.sp, modifier = Modifier.padding(end = 8.dp))
            Text(text = resultText, fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- БЛОК КНОПОК ---
        // Первый ряд кнопок
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                operationText = "+"
                val num1 = num1Text.toFloat()
                val num2 = num2Text.toFloat()
                resultText = (num1 + num2).toString()
            }, modifier = Modifier.weight(1f)) {
                Text("+", fontSize = 24.sp)
            }

            Button(onClick = {
                operationText = "-"
                val num1 = num1Text.toFloat()
                val num2 = num2Text.toFloat()
                resultText = (num1 - num2).toString()
            }, modifier = Modifier.weight(1f)) {
                Text("-", fontSize = 24.sp)
            }

            Button(onClick = {
                operationText = "*"
                val num1 = num1Text.toFloat()
                val num2 = num2Text.toFloat()
                resultText = (num1 * num2).toString()
            }, modifier = Modifier.weight(1f)) {
                Text("*", fontSize = 24.sp)
            }
        }

        // Второй ряд кнопок
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                operationText = "/"
                val num1 = num1Text.toFloat()
                val num2 = num2Text.toFloat()
                resultText = (num1 / num2).toString()
            }, modifier = Modifier.weight(1f)) {
                Text("/", fontSize = 24.sp)
            }

            Button(onClick = {
                // Кнопка очистки
                num1Text = ""
                num2Text = ""
                operationText = ""
                resultText = ""
            }, modifier = Modifier.weight(1f)) { // Занимает место двух кнопок
                Text("C", fontSize = 24.sp)
            }


        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    operationText = "x^2"
                    val n1 = num1Text.toFloat()
                    resultText = (n1 * n1).toString()
                },
                modifier = Modifier.fillMaxWidth().padding(4.dp)

            ) {
                Text("Возвести число в квадрат", fontSize = 18.sp)
            }
        }
    }
}
