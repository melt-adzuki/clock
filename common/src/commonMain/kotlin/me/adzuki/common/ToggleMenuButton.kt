package me.adzuki.common

import androidx.compose.animation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ToggleMenuButton(isMenuVisible: Boolean, onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        AnimatedContent(
            targetState = isMenuVisible,
            transitionSpec = {
                slideInVertically { -it } + fadeIn() with
                        slideOutVertically { it } + fadeOut()
            },
        ) { targetState ->
            if (!targetState) Icon(Icons.Filled.Menu, contentDescription = null)
            else Icon(Icons.Filled.Close, contentDescription = null)
        }
    }
}