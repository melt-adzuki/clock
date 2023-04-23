package me.adzuki.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

actual object PlatformFont {
    @OptIn(ExperimentalTextApi::class)
    actual val clockFace @Composable get() = Font(
        "TitilliumWeb-ExtraLight.ttf",
        LocalContext.current.assets,
        FontWeight.ExtraLight,
        FontStyle.Normal,
    )
}
