package com.example.nusgpacalculator.data.local

import androidx.room.TypeConverter
import java.util.UUID
import com.example.nusgpacalculator.data.model.Grade
import com.example.nusgpacalculator.data.model.Semester

class Converters {
    @TypeConverter
    fun fromUuid(uuid: UUID?): String? = uuid?.toString()

    @TypeConverter
    fun toUuid(uuidStr: String?): UUID? = uuidStr?.let { UUID.fromString(it) }

    @TypeConverter
    fun fromGrade(grade: Grade): String = grade.name

    @TypeConverter
    fun toGrade(gradeStr: String): Grade = Grade.valueOf(gradeStr)

    // Semester enum ↔ String
    @TypeConverter
    fun fromSemester(semester: Semester): String = semester.name

    @TypeConverter
    fun toSemester(semesterStr: String): Semester = Semester.valueOf(semesterStr)

}