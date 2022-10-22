package com.sshashank.weatherapp.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import com.sshashank.weatherapp.ui.components.BlankDate
import com.sshashank.weatherapp.ui.components.Calendar
import com.sshashank.weatherapp.ui.components.DateForecast
import java.time.Month


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarScreenPage() {
    val months = listOf(
        com.sshashank.weatherapp.ui.components.Month(
            title = "July",
            blankDates = List(5) {
                BlankDate
            },
            dateForecasts = List(Month.JULY.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    highTemperature = "70",
                    icon = Icons.Filled.WbCloudy,
                    isToday = it == 5
                )
            }
        ),
        com.sshashank.weatherapp.ui.components.Month(
            title = "August",
            blankDates = List(1) {
                BlankDate
            },
            dateForecasts = List(Month.AUGUST.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    highTemperature = "70",
                    icon = Icons.Filled.WbCloudy,
                    isToday = false
                )
            }
        )
    )
    Calendar(months = months)
}



