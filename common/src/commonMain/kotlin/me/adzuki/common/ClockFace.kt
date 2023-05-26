package me.adzuki.common

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ClockText(
    text: String,
    fontSize: TextUnit = 100.sp,
    modifier: Modifier = Modifier,
) = Text(
    text = text,
    modifier = modifier,
    fontSize = fontSize,
    fontFamily = FontFamily(PlatformFont.clockFace),
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Colon(tick: Boolean) {
    AnimatedContent(
        targetState = tick,
        transitionSpec = { EnterTransition.None with fadeOut() },
    ) { targetTick ->
        ClockText(
            text = ":",
            modifier = Modifier.alpha(if (targetTick) 1f else 0f),
        )
    }
}

@Composable
fun ClockFace() {
    val clock = useClockState()

    Center {
        Row {
            ClockText(clock.hour)
            Colon(clock.tick)
            ClockText(clock.minute)
            Colon(clock.tick)
            ClockText(clock.second)
        }

        ClockText(
            text = clock.date,
            fontSize = 40.sp,
        )
    }
}
