package com.example.sideeffects

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay


@Composable
fun RememberUpdatedState() {
    val color = remember {
        mutableStateOf("none")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Button(onClick = {
                Log.d("TAG", "RememberUpdatedState: Red")
                color.value = "Red"
            }) {
                Text(text = "Red")
            }
            Button(onClick = {
                Log.d("TAG", "RememberUpdatedState: Blue")
                color.value = "Blue"
            }) {

                Text(text = "Blue")
            }
        }
    }
    Timer(color = color.value)
}

@Composable
fun Timer(color: String) {

    val colors = rememberUpdatedState(newValue = color)

    LaunchedEffect(key1 = Unit, block = {
        delay(4000)
        Log.d("TAG", "Timer: ${colors.value}")
    })
    Log.d("TAGOUTSIDWE", "Timer: ${colors.value}")

}