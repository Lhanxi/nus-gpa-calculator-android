package com.example.nusgpacalculator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.nusgpacalculator.data.local.ModuleEntity
import com.example.nusgpacalculator.data.model.Grade
import com.example.nusgpacalculator.data.model.Semester
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.KeyboardType
import com.example.nusgpacalculator.ui.components.EnumDropdown

@Composable
fun AddModuleScreen(
    onAddModule: (ModuleEntity) -> Unit,
    onBack: () -> Unit
) {
    var moduleCode by remember { mutableStateOf("") }
    var credits by remember { mutableStateOf("") }
    var selectedGrade by remember { mutableStateOf(Grade.A) }
    var selectedSemester by remember { mutableStateOf(Semester.YEAR_ONE_SEM_ONE) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = moduleCode,
            onValueChange = { moduleCode = it },
            label = { Text("Module Code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = credits,
            onValueChange = { credits = it },
            label = { Text("Credits") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        EnumDropdown(
            label = "Grade",
            options = Grade.values().toList(),
            selectedOption = selectedGrade,
            onOptionSelected = { selectedGrade= it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        EnumDropdown(
            label = "Semester",
            options = Semester.values().toList(),
            selectedOption = selectedSemester,
            onOptionSelected = { selectedSemester = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val module = ModuleEntity(
                    moduleCode = moduleCode,
                    credits = credits.toIntOrNull() ?: 0,
                    grade = selectedGrade,
                    semester = selectedSemester
                )
                onAddModule(module)
                onBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Module")
        }
    }
}
