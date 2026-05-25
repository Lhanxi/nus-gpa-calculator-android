package com.example.nusgpacalculator.data.local

import androidx.room.*
import java.util.UUID
import com.example.nusgpacalculator.data.model.Grade
import com.example.nusgpacalculator.data.model.Semester

@Entity(tableName = "modules")
data class ModuleEntity(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "module_code") val moduleCode: String,
    val credits: Int,
    val grade: Grade,
    val semester: Semester
)
