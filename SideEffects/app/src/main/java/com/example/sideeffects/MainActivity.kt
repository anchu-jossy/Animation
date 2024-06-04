package com.example.sideeffects

import FormScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.sideeffects.ui.theme.SideEffectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SideEffectsTheme {
                Surface {
                 //   LaunchEffectExample(viewModel = FakeViewModel())
                    //  RememberUpdatedState()
                 //   DisposibleSideEffect(this,this.onBackPressedDispatcher)
                   // MyApp()
                    FormScreen()
                }
            }
        }
    }
}

