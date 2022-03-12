package com.github.nthily

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.github.nthily.library.Library

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MinimalComposeMultiplatformJniDemo",
        state = rememberWindowState(width = 1290.dp, height = 850.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = Library.getStrFromRust("Hello World !"),
                style = MaterialTheme.typography.h2
            )
        }
    }
}
