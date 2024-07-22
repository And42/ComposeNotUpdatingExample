package com.example.composenotupdatingexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exampleNumber = 1

        setContent {
            when (exampleNumber) {
                1 -> Example1()
                2 -> Example2()
                3 -> Example3()
            }
        }
    }
}

@Composable
private fun Example1() {
    println("Testing: Example 1 recomposed")

    val text: MutableState<String> = remember { mutableStateOf("Hello") }

    BasicText(text = text.value)

    text.value = "World"
}

@Composable
private fun Example2() {
    println("Testing: Example 2 recomposed")

    val text: MutableState<String> = remember { mutableStateOf("Hello") }

    BasicText(text = text.value)

    LaunchedEffect(Unit) {
        text.value = "World"
    }
}

@Composable
private fun Example3() {
    println("Testing: Example 3 recomposed")

    val render: MutableState<Boolean> = remember { mutableStateOf(false) }

    if (render.value) {
        val text: MutableState<String> = remember { mutableStateOf("Hello") }

        BasicText(text = text.value)

        text.value = "World"
    }

    LaunchedEffect(Unit) {
        render.value = true
    }
}