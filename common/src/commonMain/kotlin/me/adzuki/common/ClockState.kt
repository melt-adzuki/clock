package me.adzuki.common

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

val datePattern = DateTimeFormatter.ofPattern("MM/dd (E)")!!

private val Int.digit get() =
    this.toString().padStart(2, '0')

data class DateTime(
    val hour: String,
    val minute: String,
    val second: String,
    val date: String,
    val tick: Boolean,
)

@Composable
fun useClockState(): DateTime {
    var date by remember { mutableStateOf(LocalDateTime.now()) }
    var tick by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            date = LocalDateTime.now()
            launch {
                tick = true
                delay(0.5.seconds)
                tick = false
            }
            delay((1_000_000_000 - date.nano).nanoseconds)
        }
    }

    return DateTime(
        hour = date.hour.digit,
        minute = date.minute.digit,
        second = date.second.digit,
        date = date.format(datePattern),
        tick = tick,
    )
}
