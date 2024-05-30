package com.example.proguniver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavGraph(navController)
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            ProfileScreen(navController = navController)
        }
        composable("orders") {
            Orders(navController = navController)
        }
        composable("helpers") {
            Helpers(navController = navController)
        }
        composable("helping") {
            HelpingAsking(navController = navController)
        }
        composable("profile") {
            UserProfileScreen(navController = navController)
        }
    }
}
