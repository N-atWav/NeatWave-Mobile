package com.example.proguniver

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.util.Date


data class Helping(
    val helpingId: String,
    val date: Date,
    val status: String,
    val topic: String,
)


@Composable
fun Helpers(navController: NavHostController) {
    val orders = listOf(
        Helping("001", Date(), "Оброблюється", "Робота програми"),
        Helping("002", Date(), "Закрито", "Робота працівників"),
        Helping("003", Date(), "Чекає на відповідь", "Проблеми зі сплатою"),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(160.dp))
        Text(
            fontSize = 34.sp,
            text = "Звернення",
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(orders)
            { Helping ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Номер звернення: ${Helping.helpingId}",  fontSize = 16.sp,)
                    Text("Дата: ${Helping.date}",  fontSize = 16.sp,)
                    Text("Статус: ${Helping.status}", fontSize = 16.sp,)
                    Text("Тема: ${Helping.topic}",  fontSize = 16.sp,)
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Для центрирования по вертикали
        ) {
            Button(
                border = BorderStroke(1.dp, Color.Black),
                onClick = { navController.navigate("main")  },
                modifier = Modifier.padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black // Цвет текста на кнопке
                ),
            ) {
                Text("Повернутися")
            }
            Spacer(modifier = Modifier.height(8.dp)) // Пространство между кнопками
            Button(
                border = BorderStroke(1.dp, Color.Black),
                onClick = { navController.navigate("helping") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black // Цвет текста на кнопке
                ),
                modifier = Modifier.padding(8.dp),
            ) {
                Text("Написати нове звернення")
            }
        }
    }
}
