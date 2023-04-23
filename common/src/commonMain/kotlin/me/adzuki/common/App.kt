package me.adzuki.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun App(
    exit: () -> Unit = { },
    toggleFullscreen: () -> Unit = { },
) {
    MaterialTheme(
        colors = darkColors(background = Color.Black)
    ) {
        var isMenuVisible by remember { mutableStateOf(false) }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { isMenuVisible = !isMenuVisible }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            }
        ) {
            ClockFace()
            Menu(
                isVisible = isMenuVisible,
                exit,
                toggleFullscreen,
            )
        }
    }
}
