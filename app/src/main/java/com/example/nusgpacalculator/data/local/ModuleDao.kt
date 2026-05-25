package com.example.nusgpacalculator.data.local

import androidx.room.*

@Dao
interface ModuleDao {
    @Query("SELECT * FROM modules ORDER BY module_code")
    suspend fun getAllModules(): List<ModuleEntity>

    @Delete
    suspend fun deleteModule(module: ModuleEntity)

    @Query("SELECT * FROM modules WHERE semester = :semester ORDER BY module_code")
    suspend fun getModulesBySemester(semester: String): List<ModuleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModule(module: ModuleEntity)
}