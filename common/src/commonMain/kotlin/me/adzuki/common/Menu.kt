package me.adzuki.common

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Menu(
    isVisible: Boolean,
    exit: () -> Unit,
    toggleFullscreen: () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandHorizontally() + fadeIn(),
        exit = shrinkHorizontally() + fadeOut(),
        modifier = Modifier.background(Color(0, 0, 0, 128 + 64))
    ) {
        Center {
            Row(
                horizontalArrangement = Arrangement.spacedBy(25.dp),
            ) {
                MenuButton(onClick = { exit() }) {
                    Text("Exit")
                }

                MenuButton(onClick = { toggleFullscreen() }) {
                    Text("Fullscreen")
                }
            }
        }
    }
}

@Composable
private fun MenuButton(
    onClick: () -> Unit = { },
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(150.dp).height(150.dp),
    ) {
        content()
    }
}
