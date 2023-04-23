package me.adzuki.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual object PlatformFont {
    actual val clockFace @Composable get() = Font(
        "TitilliumWeb-ExtraLight.ttf",
        FontWeight.ExtraLight,
        FontStyle.Normal,
    )
}
