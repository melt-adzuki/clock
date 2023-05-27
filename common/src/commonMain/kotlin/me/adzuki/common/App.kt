package me.adzuki.common

import androidx.compose.material3.*
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    platformOperations: PlatformOperations,
) = CompositionLocalProvider(LocalPlatformOperations provides platformOperations) {
    var isMenuVisible by mutableStateOf(false)

    Scaffold(
        floatingActionButton = {
            ToggleMenuButton(
                isMenuVisible = isMenuVisible,
                onClick = { isMenuVisible = !isMenuVisible },
            )
        }
    ) {
        ClockFace()
        Menu(isVisible = isMenuVisible)
    }
}
