package com.example.nusgpacalculator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nusgpacalculator.data.util.calculateGPA
import com.example.nusgpacalculator.viewmodel.ModuleViewModel

@Composable
fun HomeScreen(
    moduleViewModel: ModuleViewModel,
    onNavigateToAddModule: () -> Unit
) {
    val modules = moduleViewModel.modules
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Current GPA: %.2f".format(calculateGPA(modules)),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNavigateToAddModule,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Module")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ModuleListScreen(
            modules = modules,
            onDelete = { moduleViewModel.deleteModule(it) }
        )
    }
}