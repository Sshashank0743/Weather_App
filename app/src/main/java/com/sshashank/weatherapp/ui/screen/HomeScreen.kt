package com.sshashank.weatherapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import com.sshashank.weatherapp.ui.components.HourlyForecast
import com.sshashank.weatherapp.ui.components.HourlyForecastSheet

@Composable
fun HomeScreenPage() {
    Column() {
        HourlyForecastSheet(
            List(7) {
                HourlyForecast(
                    descriptor = "Cloudy",
                    icon = Icons.Filled.WbCloudy,
                    hour = "19:00",
                    temperature = "20"
                )
            }
        )
    }
}