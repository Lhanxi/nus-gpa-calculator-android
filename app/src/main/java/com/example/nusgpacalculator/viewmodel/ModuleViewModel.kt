package com.example.nusgpacalculator.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.nusgpacalculator.data.local.AppDatabase
import com.example.nusgpacalculator.data.local.ModuleEntity
import kotlinx.coroutines.launch

class ModuleViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).moduleDao()

    var modules by mutableStateOf<List<ModuleEntity>>(emptyList())
        private set

    init {
        loadModules()
    }

    fun loadModules() {
        viewModelScope.launch {
            modules = dao.getAllModules()
        }
    }

    fun addModule(module: ModuleEntity) {
        viewModelScope.launch {
            dao.insertModule(module)
            loadModules()
        }
    }

    fun deleteModule(module: ModuleEntity) {
        viewModelScope.launch {
            dao.deleteModule(module)
            loadModules()
        }
    }
}