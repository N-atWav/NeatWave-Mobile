package com.example.proguniver

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun UserProfileScreen (navController: NavHostController) {

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 62.dp)
                    .height(56.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Профіль користувача",
                    fontSize = 35.sp
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


            Spacer(modifier = Modifier.height(26.dp))

            // Имя пользователя
            Text(
                text = "Іван Іванов",
                fontSize = 34.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Email пользователя
            Text(
                text = "E-mail: ivan.ivanov@example.com",
                fontSize = 24.sp
            )


            Spacer(modifier = Modifier.height(16.dp))

            // Количество заказов
            Text(
                text = "Кількість замовленнь: 10",
                modifier = Modifier.align(Alignment.Start),
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Количество неоплаченных заказов
            Text(
                text = "Кількість невиплачених замовлень: 0",
                modifier = Modifier.align(Alignment.Start),
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Адрес по умолчанию
            Text(
                text = "Адреса за умовчанням: ул. Додаткова, д. 1, кв. 1",
                modifier = Modifier.align(Alignment.Start),
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            // Кнопка выхода из профиля
            Button(
                onClick = {  navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black // Цвет текста на кнопке
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text("Повернутися у головне меню", fontSize = 18.sp)

            }
        }
    }
}