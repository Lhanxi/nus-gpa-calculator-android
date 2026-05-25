package com.example.nusgpacalculator.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nusgpacalculator.ui.screens.AddModuleScreen
import com.example.nusgpacalculator.ui.screens.HomeScreen
import com.example.nusgpacalculator.viewmodel.ModuleViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddModule : Screen("add_module")
}

@Composable
fun AppNavGraph(moduleViewModel: ModuleViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                moduleViewModel = moduleViewModel,
                onNavigateToAddModule = { navController.navigate(Screen.AddModule.route) }
            )
        }

        composable(Screen.AddModule.route) {
            AddModuleScreen(
                onAddModule = { moduleViewModel.addModule(it) },
                onBack = { navController.popBackStack() }
            )
        }
    }
}