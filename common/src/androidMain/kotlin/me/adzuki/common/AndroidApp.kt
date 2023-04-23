package me.adzuki.common

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun AndroidApp() {
    var showWrongOperationDialog by remember { mutableStateOf(false) }

    App(
        exit = { showWrongOperationDialog = !showWrongOperationDialog },
        toggleFullscreen = { showWrongOperationDialog = !showWrongOperationDialog },
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
