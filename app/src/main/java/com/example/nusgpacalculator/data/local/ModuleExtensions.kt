package com.example.nusgpacalculator.data.local

import com.example.nusgpacalculator.data.local.ModuleEntity
import com.example.nusgpacalculator.data.model.Semester

fun List<ModuleEntity>.groupedBySemester(): Map<Semester, List<ModuleEntity>> {
    return this.groupBy { it.semester }
}