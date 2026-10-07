package com.pemmob.haydarbuku.ui

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavHost(viewModel: BookViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel) { book ->
                navController.navigate("detail/${Uri.encode(book.key ?: "")}")
            }
        }
        composable(
            route = "detail/{key}",
            arguments = listOf(navArgument("key") { type = NavType.StringType })
        ) { entry ->
            val book = viewModel.findBook(entry.arguments?.getString("key"))
            DetailScreen(book = book, onBack = { navController.popBackStack() })
        }
    }
}