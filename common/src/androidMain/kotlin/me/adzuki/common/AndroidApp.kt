package me.adzuki.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import me.adzuki.common.theme.AppTheme

@Composable
fun AndroidApp() {
    var isDarkModeToggled by rememberSaveable { mutableStateOf(false) }
    val isDarkMode = isDarkModeToggled xor isSystemInDarkTheme()

    AppTheme(useDarkTheme = isDarkMode) {
        var showWrongOperationDialog by remember { mutableStateOf(false) }

        App(
            platformOperations = PlatformOperations(
                exit = { showWrongOperationDialog = !showWrongOperationDialog },
                toggleFullscreen = { showWrongOperationDialog = !showWrongOperationDialog },
                toggleDarkMode = { isDarkModeToggled = !isDarkModeToggled },
            )
        )

        if (showWrongOperationDialog) AlertDialog(
            onDismissRequest = { },
            title = { Text("エラー") },
            text = { Text("Android端末でこの操作を実行することはできません。") },
            confirmButton = {
                TextButton(onClick = { showWrongOperationDialog = !showWrongOperationDialog }) {
                    Text("OK")
                }
            },
        )
    }
}
