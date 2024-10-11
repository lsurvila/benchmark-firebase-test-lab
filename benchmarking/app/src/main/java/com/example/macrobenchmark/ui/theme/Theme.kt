/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.macrobenchmark.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette =
    JetsnackColors(
        brand = Shadow5,
        brandSecondary = Ocean3,
        uiBackground = Neutral0,
        uiBorder = Neutral4,
        uiFloated = FunctionalGrey,
        textSecondary = Neutral7,
        textHelp = Neutral6,
        textInteractive = Neutral0,
        textLink = Ocean11,
        iconSecondary = Neutral7,
        iconInteractive = Neutral0,
        iconInteractiveInactive = Neutral1,
        error = FunctionalRed,
        gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
        gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
        gradient31 = listOf(Shadow2, Ocean3, Shadow4),
        gradient32 = listOf(Rose2, Lavender3, Rose4),
        gradient21 = listOf(Shadow4, Shadow11),
        gradient22 = listOf(Ocean3, Shadow3),
        gradient23 = listOf(Lavender3, Rose2),
        tornado1 = listOf(Shadow4, Ocean3),
        isDark = false,
    )

private val DarkColorPalette =
    JetsnackColors(
        brand = Shadow1,
        brandSecondary = Ocean2,
        uiBackground = Neutral8,
        uiBorder = Neutral3,
        uiFloated = FunctionalDarkGrey,
        textPrimary = Shadow1,
        textSecondary = Neutral0,
        textHelp = Neutral1,
        textInteractive = Neutral7,
        textLink = Ocean2,
        iconPrimary = Shadow1,
        iconSecondary = Neutral0,
        iconInteractive = Neutral7,
        iconInteractiveInactive = Neutral6,
        error = FunctionalRedDark,
        gradient61 = listOf(Shadow5, Ocean7, Shadow9, Ocean7, Shadow5),
        gradient62 = listOf(Rose11, Lavender7, Rose8, Lavender7, Rose11),
        gradient31 = listOf(Shadow9, Ocean7, Shadow5),
        gradient32 = listOf(Rose8, Lavender7, Rose11),
        gradient21 = listOf(Ocean3, Shadow3),
        gradient22 = listOf(Ocean4, Shadow2),
        gradient23 = listOf(Lavender3, Rose3),
        tornado1 = listOf(Shadow4, Ocean3),
        isDark = true,
    )

@Composable
fun JetsnackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.uiBackground.copy(alpha = ALPHA_NEAR_OPAQUE),
        )
    }

    ProvideJetsnackColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

object JetsnackTheme {
    val colors: JetsnackColors
        @Composable
        get() = LocalJetsnackColors.current
}

/**
 * Jetsnack custom Color Palette
 */
@Stable
class JetsnackColors(
    gradient61: List<Color>,
    gradient62: List<Color>,
    gradient31: List<Color>,
    gradient32: List<Color>,
    gradient21: List<Color>,
    gradient22: List<Color>,
    gradient23: List<Color>,
    brand: Color,
    brandSecondary: Color,
    uiBackground: Color,
    uiBorder: Color,
    uiFloated: Color,
    interactivePrimary: List<Color> = gradient21,
    interactiveSecondary: List<Color> = gradient22,
    interactiveMask: List<Color> = gradient61,
    textPrimary: Color = brand,
    textSecondary: Color,
    textHelp: Color,
    textInteractive: Color,
    textLink: Color,
    tornado1: List<Color>,
    iconPrimary: Color = brand,
    iconSecondary: Color,
    iconInteractive: Color,
    iconInteractiveInactive: Color,
    error: Color,
    notificationBadge: Color = error,
    isDark: Boolean,
) {
    var gradient61 by mutableStateOf(gradient61)
        private set
    var gradient62 by mutableStateOf(gradient62)
        private set
    private var gradient31 by mutableStateOf(gradient31)
    var gradient32 by mutableStateOf(gradient32)
        private set
    private var gradient21 by mutableStateOf(gradient21)
    var gradient22 by mutableStateOf(gradient22)
        private set
    var gradient23 by mutableStateOf(gradient23)
        private set
    var brand by mutableStateOf(brand)
        private set
    var brandSecondary by mutableStateOf(brandSecondary)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var uiFloated by mutableStateOf(uiFloated)
        private set
    var interactivePrimary by mutableStateOf(interactivePrimary)
        private set
    var interactiveSecondary by mutableStateOf(interactiveSecondary)
        private set
    private var interactiveMask by mutableStateOf(interactiveMask)
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var textInteractive by mutableStateOf(textInteractive)
        private set
    var tornado1 by mutableStateOf(tornado1)
        private set
    var textLink by mutableStateOf(textLink)
        private set
    var iconPrimary by mutableStateOf(iconPrimary)
        private set
    var iconSecondary by mutableStateOf(iconSecondary)
        private set
    var iconInteractive by mutableStateOf(iconInteractive)
        private set
    var iconInteractiveInactive by mutableStateOf(iconInteractiveInactive)
        private set
    var error by mutableStateOf(error)
        private set
    private var notificationBadge by mutableStateOf(notificationBadge)
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: JetsnackColors) {
        gradient61 = other.gradient61
        gradient62 = other.gradient62
        gradient31 = other.gradient31
        gradient32 = other.gradient32
        gradient21 = other.gradient21
        gradient22 = other.gradient22
        gradient23 = other.gradient23
        brand = other.brand
        brandSecondary = other.brandSecondary
        uiBackground = other.uiBackground
        uiBorder = other.uiBorder
        uiFloated = other.uiFloated
        interactivePrimary = other.interactivePrimary
        interactiveSecondary = other.interactiveSecondary
        interactiveMask = other.interactiveMask
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textHelp = other.textHelp
        textInteractive = other.textInteractive
        textLink = other.textLink
        tornado1 = other.tornado1
        iconPrimary = other.iconPrimary
        iconSecondary = other.iconSecondary
        iconInteractive = other.iconInteractive
        iconInteractiveInactive = other.iconInteractiveInactive
        error = other.error
        notificationBadge = other.notificationBadge
        isDark = other.isDark
    }

    fun copy(): JetsnackColors =
        JetsnackColors(
            gradient61 = gradient61,
            gradient62 = gradient62,
            gradient31 = gradient31,
            gradient32 = gradient32,
            gradient21 = gradient21,
            gradient22 = gradient22,
            gradient23 = gradient23,
            brand = brand,
            brandSecondary = brandSecondary,
            uiBackground = uiBackground,
            uiBorder = uiBorder,
            uiFloated = uiFloated,
            interactivePrimary = interactivePrimary,
            interactiveSecondary = interactiveSecondary,
            interactiveMask = interactiveMask,
            textPrimary = textPrimary,
            textSecondary = textSecondary,
            textHelp = textHelp,
            textInteractive = textInteractive,
            textLink = textLink,
            tornado1 = tornado1,
            iconPrimary = iconPrimary,
            iconSecondary = iconSecondary,
            iconInteractive = iconInteractive,
            iconInteractiveInactive = iconInteractiveInactive,
            error = error,
            notificationBadge = notificationBadge,
            isDark = isDark,
        )
}

@Composable
fun ProvideJetsnackColors(
    colors: JetsnackColors,
    content: @Composable () -> Unit,
) {
    val colorPalette =
        remember {
            // Explicitly creating a new object here so we don't mutate the initial [colors]
            // provided, and overwrite the values set in it.
            colors.copy()
        }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalJetsnackColors provides colorPalette, content = content)
}

private val LocalJetsnackColors =
    staticCompositionLocalOf<JetsnackColors> {
        error("No JetsnackColorPalette provided")
    }

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [JetsnackTheme.colors].
 */
fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta,
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme,
)
