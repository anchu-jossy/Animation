package com.example.datapreferences

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _flagEnabled = MutableStateFlow<Boolean>(false)
    val flagEnabled = _flagEnabled.asStateFlow()
    private val context = getApplication<Application>().applicationContext
    private var dataValKeyStore: PreDataValKeyStore = PreDataValKeyStore(context)

    init {
        viewModelScope.launch {
            dataValKeyStore.getFlagFlow.collect { flagValue ->
                // Here, flagValue contains the current value of the exampleFlag
                // You can use it as needed, for example:
                println("Flag value: $flagValue")
                _flagEnabled.value = flagValue
            }
        }
    }

    suspend fun toggleFlag() {
        viewModelScope.launch {
            val toggledFlagValue = !_flagEnabled.value
            dataValKeyStore.updateFlag(toggledFlagValue)
            _flagEnabled.value = toggledFlagValue
        }
    }
}