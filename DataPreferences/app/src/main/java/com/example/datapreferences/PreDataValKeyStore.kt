package com.example.datapreferences

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property to create the DataStore
val Context.dataStore by preferencesDataStore(name = "example")

class PreDataValKeyStore(val context: Context) {

    object PreferenceKeys {
        val exampleFlag: Preferences.Key<Boolean> = booleanPreferencesKey("example_flag")
    }

    // Additional functions to interact with the DataStore can be added here


    // Get the current value of exampleFlag
    val getFlagFlow: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[PreferenceKeys.exampleFlag] ?: false
        }

    // Function to update the value of exampleFlag
    suspend fun updateFlag(value: Boolean) =
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.exampleFlag] = value
        }

}
