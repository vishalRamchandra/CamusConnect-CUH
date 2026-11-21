package com.example.campusconnect.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryRose,
    onPrimary = CardSurface,
    primaryContainer = SecondarySurface,
    onPrimaryContainer = TextPrimary,
    secondary = SecondarySurface,
    onSecondary = TextPrimary,
    background = BackgroundBlush,
    onBackground = TextPrimary,
    surface = CardSurface,
    onSurface = TextPrimary,
    outline = BorderLight
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryRoseLight,
    onPrimary = TextPrimary,
    primaryContainer = PrimaryRoseDark,
    onPrimaryContainer = CardSurface,
    secondary = PrimaryRoseDark,
    onSecondary = CardSurface,
    background = TextPrimary,
    onBackground = BackgroundBlush,
    surface = TextPrimary,
    onSurface = BackgroundBlush,
    outline = TextSecondary
)

@Composable
fun CampusConnectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}