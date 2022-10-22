package com.sshashank.weatherapp.ui.components

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sshashank.weatherapp.R
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme

sealed class Screen(
    val route: String,
    @StringRes val stringRes: Int,
    val iconRes: ImageVector
) {
    object Home : Screen("home", R.string.nav_home, Icons.Filled.Home)
    object Calendar : Screen("calendar", R.string.nav_calendar, Icons.Filled.CalendarMonth)
    object Settings : Screen("settings", R.string.nav_settings, Icons.Filled.Settings)
}

val screens = listOf(
    Screen.Home,
    Screen.Calendar,
    Screen.Settings
)

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    selectedScreen: Screen = Screen.Home,
    onSelectItem: (Screen) -> Unit = {},
) = BottomNavigation(modifier) {
    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = screen == selectedScreen,
                onClick = {
                    onSelectItem(screen)
                },
                alwaysShowLabel = false,
                icon = { Icon(imageVector = screen.iconRes, contentDescription = null)},
                label = { Text(stringResource(id = screen.stringRes)) },
                unselectedContentColor = Color.LightGray
            )
        }
    }
}


@Preview
@Composable
fun NavigationPreview() {
    WeatherAppTheme {
        Navigation()
    }
}


@Preview
@Composable
fun NavigationPreviewDark() {
    WeatherAppTheme(darkTheme = true) {
        Navigation()
    }
}