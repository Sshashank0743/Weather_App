package com.sshashank.weatherapp.Home

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sshashank.weatherapp.ui.components.*
import com.sshashank.weatherapp.ui.theme.Black
import com.sshashank.weatherapp.ui.theme.DarkGray
import com.sshashank.weatherapp.ui.theme.LightGray

data class HomeScreenState(
    val currentWeather: CurrentWeather,
    val currentConditions: List<CurrentCondition>,
    val hourlyForecast: List<HourlyForecast>,
    val icon: ImageVector
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    state: HomeScreenState,
    modifier: Modifier = Modifier,
) {
    val colors = if (isSystemInDarkTheme()) {
        listOf(
            DarkGray,
            Black
        )
    } else {
        listOf(
            Color.White,
            LightGray
        )
    }
    Brush.verticalGradient()
    Scaffold(
        modifier = modifier.background(
            brush = Brush.verticalGradient(colors)
        ),
        backgroundColor = Color.Unspecified,
        bottomBar = { Navigation() }
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            CurrentWeatherField(state.currentWeather)
            CurrentConditionRow(
            currentConditions = state.currentConditions,
            modifier = Modifier.padding(bottom = 16.dp)
            )
            HourlyForecastSheet(
            hourlyForecast = state.hourlyForecast,
            modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Preview(
    device = Devices.PIXEL_4,
    uiMode = UI_MODE_NIGHT_YES
)

@Composable
fun HomeScreenPreview() {
    val state = HomeScreenState(
        currentWeather = CurrentWeather(
            location = "India",
            date = "Today, 12 July",
            icon = Icons.Filled.WbCloudy,
            weatherDescription = "Lightly Cloudy"
        ),
        currentConditions = listOf(
            CurrentCondition("Wind", "234"),
            CurrentCondition("Temp", "16"),
            CurrentCondition("Humidity", "23%")
        ),
        hourlyForecast = List(7) {
            HourlyForecast(
                descriptor = "Cloudy",
                icon = Icons.Filled.WbCloudy,
                hour = "19:00",
                temperature = "20"
            )

        },
        icon = Icons.Filled.WbCloudy
    )
}
