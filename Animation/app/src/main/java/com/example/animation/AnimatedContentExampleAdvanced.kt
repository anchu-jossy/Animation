package com.example.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExampleAdvanced() {
    var expanded by remember {
        mutableStateOf(true)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(
            colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.secondary),
            modifier = Modifier.clickable { expanded = !expanded }) {
            AnimatedContent(targetState = expanded, transitionSpec = {
                fadeIn() with fadeOut() using SizeTransform { initialSize, targetSize ->
                    if (expanded) {
                        keyframes {
                            IntSize(width = targetSize.width, height = initialSize.height) at 150
                            durationMillis = 1000
                        }
                    } else {
                        keyframes {
                            IntSize(width = initialSize.width, height = initialSize.height) at 150
                            durationMillis = 1000
                        }
                    }

                }
            }) { targetSize ->
                if (targetSize) {
                    Expanded()
                } else {
                    Shrink()
                }
            }
        }
    }
}

@Composable
fun Expanded() {
    Text(
        modifier = Modifier
            .background(color = Color.Green)
            .padding(12.dp),
        text =
        "Artificial intelligence was founded as an academic discipline in 1956, and in the years since has experienced several waves of optimism,[6][7] followed by disappointment and the loss of funding (known as an \"AI winter\"),[8][9] followed by new approaches, success and renewed funding.[7][10] AI research has tried and discarded many different approaches since its founding, including simulating the brain, modeling human problem solving, formal logic, large databases of knowledge and imitating animal behavior. In the first decades of the 21st century, highly mathematical-statistical machine learning has dominated the field, and this technique has proved highly successful, helping to solve many challenging problems throughout industry and academia.[10][11]",
    )
}

@Composable
fun Shrink() {

    Icon(
        imageVector = Icons.Default.Add,
        contentDescription = null,
        modifier = Modifier
            .padding(12.dp)
            .size(50.dp)
            .background(color = Color.Green)
    )

}