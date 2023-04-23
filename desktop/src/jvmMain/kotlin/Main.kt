import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.adzuki.common.App
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

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
        App(
            exit = ::exitApplication,
            toggleFullscreen = { isFullscreen = !isFullscreen }
        )
    }
}
