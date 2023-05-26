package me.adzuki.common

import androidx.compose.runtime.staticCompositionLocalOf

class PlatformOperations(
    val exit: () -> Unit = { },
    val toggleFullscreen: () -> Unit = { },
    val toggleDarkMode: () -> Unit = { },
)

val LocalPlatformOperations = staticCompositionLocalOf {
    PlatformOperations()
}
