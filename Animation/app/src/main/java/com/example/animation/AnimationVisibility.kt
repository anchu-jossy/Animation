package com.example.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimationVisibilityExample() {
    var isVisble by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = isVisble,
            enter = fadeIn(
                animationSpec = tween(durationMillis = 1000)
            ) + expandHorizontally() + scaleIn(
                initialScale = 0f,
                transformOrigin = TransformOrigin.Center
            ) + slideIn(initialOffset = { IntOffset(x = 100, y = 100) }),
            exit = fadeOut()+
            slideOutHorizontally()+ slideOut  (targetOffset = { IntOffset(x = -100, y = -100)}))


            {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(
                        CircleShape
                    ),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isVisble = !isVisble }) {
            Text(text = "Click")

        }
    }
}