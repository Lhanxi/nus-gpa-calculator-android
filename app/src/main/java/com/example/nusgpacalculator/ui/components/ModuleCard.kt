package com.example.nusgpacalculator.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nusgpacalculator.data.local.ModuleEntity
import androidx.compose.material3.Text

@Composable
fun ModuleCard(
    module: ModuleEntity,
    onDelete: (ModuleEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = module.moduleCode,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Credits: ${module.credits}, Grade: ${module.grade.name}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = { onDelete(module)} ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Module"
                )
            }
        }
    }
}