package me.adzuki.common


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    exit: () -> Unit = { },
    toggleFullscreen: () -> Unit = { },
) {
    MaterialTheme(
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
