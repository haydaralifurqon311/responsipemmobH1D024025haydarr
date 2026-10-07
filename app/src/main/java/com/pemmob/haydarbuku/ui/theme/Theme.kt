package com.pemmob.haydarbuku.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = TealPrimary,
    onPrimary = PureWhite,
    primaryContainer = Color(0xFFCCFBF1),
    onPrimaryContainer = Color(0xFF042F2E),
    secondary = MintSecondary,
    onSecondary = Color(0xFF042F2E),
    tertiary = AmberAccent,
    onTertiary = Color(0xFF1F1300),
    background = PureWhite,
    onBackground = InkText,
    surface = PureWhite,
    onSurface = InkText,
    surfaceVariant = LightGray,
    onSurfaceVariant = Color(0xFF4B5563)
)

private val DarkColors = darkColorScheme(
    primary = MintSecondary,
    onPrimary = Color(0xFF003733),
    primaryContainer = TealPrimary,
    onPrimaryContainer = PureWhite,
    secondary = MintSecondary,
    onSecondary = Color(0xFF003733),
    tertiary = AmberAccent,
    onTertiary = Color(0xFF1F1300),
    background = DarkSurface,
    onBackground = LightGray,
    surface = DarkSurface,
    onSurface = LightGray,
    surfaceVariant = Color(0xFF1F2937),
    onSurfaceVariant = Color(0xFFD1D5DB)
)

@Composable
fun BookFinderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}