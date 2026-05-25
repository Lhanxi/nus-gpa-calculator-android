package com.example.nusgpacalculator.data.util

import com.example.nusgpacalculator.data.local.ModuleEntity

fun calculateGPA(modules: List<ModuleEntity>) : Double {
    val totalCredits = modules.sumOf { it.credits }
    if (totalCredits == 0) return 0.0

    val totalPoints = modules.sumOf { module ->
        module.grade.gradePoint?.let { it * module.credits } ?: 0.0
    }

    return totalPoints / totalCredits
}