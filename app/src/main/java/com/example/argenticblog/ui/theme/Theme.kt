package com.example.argenticblog.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    background = BackgroundColor,
    surface = SurfaceColor,  // Added surface color
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onBackground = OnBackgroundColor,
    onSurface = OnSurfaceColor,  // Added onSurface color
    error = ErrorColor
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    background = Color.Black,
    surface = Color.DarkGray,  // Dark mode surface color
    onPrimary = Color.White,
    onSecondary = Color.Gray,
    onBackground = Color.White,
    onSurface = Color.White,  // Dark mode onSurface color
    error = ErrorColor
)

@Composable
fun ArgenticBlogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography, // Make sure this is defined in Typography.kt
        content = content
    )
}