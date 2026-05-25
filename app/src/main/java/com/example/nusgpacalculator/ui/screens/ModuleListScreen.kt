package com.example.nusgpacalculator.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.nusgpacalculator.data.local.ModuleEntity
import com.example.nusgpacalculator.data.local.groupedBySemester
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nusgpacalculator.ui.components.ModuleCard

@Composable
fun ModuleListScreen(
    modules: List<ModuleEntity>,
    onDelete: (ModuleEntity) -> Unit
) {
    val groupedModules = modules.groupedBySemester()

    LazyColumn {
        groupedModules.entries.forEach { (semester, moduleList) ->
            item {
                Text(
                    text = semester.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            // Modules in that semester
            items(moduleList) { module ->
                ModuleCard(module = module, onDelete = onDelete)
            }
        }
    }
}