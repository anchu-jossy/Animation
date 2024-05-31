package com.example.sideeffects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState

@Composable
fun ProduceState() {


    val url = "123"

    produceStateExample(url)
}

@Composable
fun produceStateExample(url: String): State<String> {
    return produceState(initialValue = url) {
        value = if (url == "123") "black"
        else "orange"

    }
}