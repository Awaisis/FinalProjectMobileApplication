package com.example.taskcompanion.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


//   Custom App Color Palette:
// Soft teal primary
val TealPrimary = Color(0xFF00897B)
val TealPrimaryContainer = Color(0xFFB2DFDB)

// Deep green secondary
val GreenSecondary = Color(0xFF2E7D32)

// Warm grey background
val BackgroundLight = Color(0xFFFAFAFA)

// Text colors
val TextPrimary = Color(0xFF1A1A1A)
val TextSecondary = Color(0xFF4A4A4A)


//   Light Color Scheme:
private val LightColors = lightColorScheme(
    primary = TealPrimary,
    onPrimary = Color.White,
    primaryContainer = TealPrimaryContainer,
    onPrimaryContainer = TextPrimary,

    secondary = GreenSecondary,
    onSecondary = Color.White,

    background = BackgroundLight,
    onBackground = TextPrimary,

    surface = Color.White,
    onSurface = TextPrimary
)


//   Dark Color Scheme:
private val DarkColors = darkColorScheme(
    primary = TealPrimary,
    onPrimary = Color.Black,
    primaryContainer = TealPrimaryContainer,
    onPrimaryContainer = Color.Black,

    secondary = GreenSecondary,
    onSecondary = Color.Black,

    background = Color(0xFF121212),
    onBackground = Color.White,

    surface = Color(0xFF1E1E1E),
    onSurface = Color.White
)


//   App Theme Wrapper:
@Composable
fun TaskCompanionTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme: ColorScheme =
        if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}