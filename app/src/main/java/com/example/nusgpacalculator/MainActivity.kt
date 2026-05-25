package com.example.nusgpacalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nusgpacalculator.ui.navigation.AppNavGraph
import com.example.nusgpacalculator.viewmodel.ModuleViewModel

class MainActivity : ComponentActivity() {
    private lateinit var moduleViewModel: ModuleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        moduleViewModel = ModuleViewModel(application)
        setContent {
            AppNavGraph(moduleViewModel = moduleViewModel)
        }
    }
}