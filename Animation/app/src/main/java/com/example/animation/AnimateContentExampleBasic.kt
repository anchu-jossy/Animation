package com.example.animation

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateContentExampleBasic() {
    var counter by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(20.dp))
        AnimatedContent(targetState = counter, transitionSpec = {
            Log.d("TAG",targetState.toString()+","+initialState.toString())
            if (targetState > initialState) {
                slideInVertically { fullHeight -> fullHeight } + fadeIn() with slideOutVertically { fullHeight -> -fullHeight }+ fadeOut()
            }
            else{
                slideInVertically{
                    fullHeight ->  -fullHeight
                }+ fadeIn() with  slideOutVertically { fullHeight -> -fullHeight }+ fadeOut()
            }.using(SizeTransform(clip = false))

        }, label = "") { it ->
            it
            Box(modifier = Modifier.size(180.dp), contentAlignment = Alignment.Center) {
                Text(text = "$counter", style = MaterialTheme.typography.headlineLarge)

            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { counter -= 1 }) {
            Text(text = "Decrement")
        }
    }
}