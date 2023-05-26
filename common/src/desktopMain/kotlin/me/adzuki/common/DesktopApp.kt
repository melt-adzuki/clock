package me.adzuki.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import me.adzuki.common.theme.AppTheme


@Composable
fun DesktopApp(
    exit: () -> Unit,
    toggleFullscreen: () -> Unit,
) {
    var isDarkModeToggled by remember { mutableStateOf(false) }
    val isDarkMode = isDarkModeToggled xor isSystemInDarkTheme()

    AppTheme(useDarkTheme = isDarkMode) {
        App(
            platformOperations = PlatformOperations(
                exit = exit,
                toggleFullscreen = toggleFullscreen,
                toggleDarkMode = { isDarkModeToggled = !isDarkModeToggled },
            )
        )
    }
}
