import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import me.adzuki.common.DesktopApp

fun main() = application {
    var isFullscreen by remember { mutableStateOf(false) }

    val windowState = WindowState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(800.dp, 480.dp),
        placement  =
            if (isFullscreen) WindowPlacement.Fullscreen
            else WindowPlacement.Floating,
    )

    Window(
        title = "Clock",
        state = windowState,
        onCloseRequest = ::exitApplication,
    ) {
        DesktopApp(
            exit = ::exitApplication,
            toggleFullscreen = { isFullscreen = !isFullscreen }
        )
    }
}
