package com.example.proguniver

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TextButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black // Цвет текста на кнопке
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(57.dp)
        ) {
            Text(
                text = "NeatWave",
                fontSize = 64.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 16.dp, top = 240.dp) // Отступ снизу от текста
            )

            Spacer(modifier = Modifier.weight(1f)) // Разделительная линия

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp), // Отступ между кнопками
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f)) // Добавляем пространство над кнопками{
                TextButton(text = "Профіль") {
                    navController.navigate("profile")
                }
                TextButton(text = "Замовлення") {
                    navController.navigate("orders")
                }
                TextButton(text = "Служба підтримки") {
                    navController.navigate("helpers")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f)) // Используем Spacer для размещения кнопки "Вхід" в левом углу
                    Button(onClick = { showDialog = true },
                        border = BorderStroke(1.dp, Color.Black),
                        modifier = Modifier.padding(bottom = 120.dp, top = 40.dp), // Отступ снизу от текста
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color.Black // Цвет текста на кнопке
                        ),) {
                        Text("Вхід", color = Color.Black)

                    }
                }
                if (showDialog) {
                    LoginDialog(onDismiss = { showDialog = false })
                }
            }
        }
    }
}
