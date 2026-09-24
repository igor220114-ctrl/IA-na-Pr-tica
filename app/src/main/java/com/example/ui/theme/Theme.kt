package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.data.preferences.ReaderThemeMode

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight,
    onSecondary = OnPrimaryLight,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = TertiaryLight,
    onTertiary = OnPrimaryLight,
    tertiaryContainer = TertiaryContainerLight,
    onTertiaryContainer = OnTertiaryContainerLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    onSecondary = OnPrimaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    tertiary = TertiaryDark,
    onTertiary = OnPrimaryDark,
    tertiaryContainer = TertiaryContainerDark,
    onTertiaryContainer = OnTertiaryContainerDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark
)

private val SepiaColorScheme = lightColorScheme(
    primary = PrimarySepia,
    onPrimary = OnPrimarySepia,
    primaryContainer = PrimaryContainerSepia,
    onPrimaryContainer = OnPrimaryContainerSepia,
    secondary = SecondarySepia,
    onSecondary = OnPrimarySepia,
    secondaryContainer = SecondaryContainerSepia,
    onSecondaryContainer = OnSecondaryContainerSepia,
    tertiary = PrimarySepia,
    onTertiary = OnPrimarySepia,
    background = BackgroundSepia,
    onBackground = OnBackgroundSepia,
    surface = SurfaceSepia,
    onSurface = OnSurfaceSepia,
    surfaceVariant = SurfaceVariantSepia,
    onSurfaceVariant = OnSurfaceVariantSepia
)

@Composable
fun IaNaPraticaTheme(
    themeMode: ReaderThemeMode = ReaderThemeMode.SYSTEM,
    content: @Composable () -> Unit
) {
    val systemInDark = isSystemInDarkTheme()
    val colorScheme = when (themeMode) {
        ReaderThemeMode.SYSTEM -> if (systemInDark) DarkColorScheme else LightColorScheme
        ReaderThemeMode.LIGHT -> LightColorScheme
        ReaderThemeMode.SEPIA -> SepiaColorScheme
        ReaderThemeMode.DARK -> DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
