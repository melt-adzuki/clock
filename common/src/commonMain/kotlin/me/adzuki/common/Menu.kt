package me.adzuki.common

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Menu(
    isVisible: Boolean,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandHorizontally() + fadeIn(),
        exit = shrinkHorizontally() + fadeOut(),
        modifier = Modifier.background(Color(0, 0, 0, 128 + 64))
    ) {
        Center {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                val operations = LocalPlatformOperations.current

                MenuButton(
                    text = "Exit",
                    icon = Icons.Outlined.ExitToApp,
                    onClick = { operations.exit() },
                )

                MenuButton(
                    text = "Fullscreen",
                    icon = Icons.Outlined.Fullscreen,
                    onClick = { operations.toggleFullscreen() },
                )

                MenuButton(
                    text = "Dark Mode",
                    icon = Icons.Outlined.DarkMode,
                    onClick = { operations.toggleDarkMode() },
                )
            }
        }
    }
}

@Composable
private fun MenuButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = Modifier.width(192.dp).height(128.dp),
        onClick = onClick,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Icon(
                icon,
                contentDescription = text,
                modifier = Modifier.size(48.dp),
            )
            Text(text)
        }
    }
}
