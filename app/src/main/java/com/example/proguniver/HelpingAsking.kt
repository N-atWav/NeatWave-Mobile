package com.example.proguniver

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HelpingAsking(navController: NavHostController) {
    var subject by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Button(onClick = {navController.navigate("helpers")},
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier.padding(top = 40.dp), // Отступ снизу от текста
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black // Цвет текста на кнопке
                ),) {
                Text("Повернутися", color = Color.Black)

            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Тема звернення",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Color.Black)
                .padding(8.dp) // Внутренний отступ для текста
        ) {
            if (subject.isEmpty()) {
                Text(
                    text = "Напишіть текст...",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
            BasicTextField(
                value = subject,
                onValueChange = { subject = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Текст звернення",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp) // Увеличенный текстбокс
                .border(width = 1.dp, color = Color.Black)
                .padding(8.dp) // Внутренний отступ для текста
        ) {
            if (message.isEmpty()) {
                Text(
                    text = "Напишіть текст...",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
            BasicTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.fillMaxSize(),
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { showDialog = true },
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier.padding(top = 40.dp), // Отступ снизу от текста
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black // Цвет текста на кнопке
                ),) {
                Text("Відправити запит", color = Color.Black)

                if (showDialog) {
                    OrderSentDialog(onDismiss = { showDialog = false }, navController = navController)
                }

            }
        }
    }

@Composable
fun OrderSentDialog(onDismiss: () -> Unit, navController: NavController) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                onDismiss()
                navController.navigate("main")
            }) {
                Text("Ок")
            }
        },
        text = {
            Text("Замовлення відправлено")
        }
    )
}