package com.example.sideeffects

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

@Composable
fun DisposibleSideEffect(
    mainActivity: MainActivity,
    backPressDispactcher: OnBackPressedDispatcher
) {


    val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            mainActivity.finish()
        }
    }
    DisposableEffect(key1 = backPressDispactcher) {

        backPressDispactcher.addCallback(callback)
        onDispose {
            Log.d("TAG", "DisposibleExample :OnDispose")
            callback.remove()
        }

    }

}
