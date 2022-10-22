package com.sshashank.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sshashank.weatherapp.R
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun HourlyForecastSheet (
    hourlyForecast: List<HourlyForecast>,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier.fillMaxWidth(),
    backgroundColor = MaterialTheme.colors.primary,
    shape = MaterialTheme.shapes.large.copy(
        topStart = CornerSize(16.dp),
        topEnd = CornerSize(16.dp)
    )
) {
    Column(modifier = Modifier.padding(top = 16.dp, bottom = 32.dp) ){
        TopRow()
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(hourlyForecast) { forecast ->
                HourlyForecastCard(hourlyForecast = forecast)

            }
        }
    }
}

@Composable
private fun TopRow(modifier: Modifier = Modifier) = Row(
    modifier = modifier
        .fillMaxWidth()
        .padding(
            start = 16.dp,
            end = 16.dp
        ),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
        Text(
            text = stringResource(id = R.string.today),
            style = MaterialTheme.typography.h6.copy(fontSize = 16.sp)
        )
        Text(
            text = stringResource(id = R.string.next_seven_days),
            style = MaterialTheme.typography.subtitle2.copy(fontSize = 12.sp)
        )

}


@Preview
@Composable
fun HourlyForecastSheetPreview() {
    val forecast = List(7) {
        HourlyForecast(
            descriptor = "Cloudy",
            icon = Icons.Filled.WbCloudy,
            hour = "19:00",
            temperature = "20"
        )
    }
    WeatherAppTheme {
        HourlyForecastSheet(hourlyForecast = forecast)
    }
}


@Preview
@Composable
fun HourlyForecastSheetPreviewDark() {
    val forecast = List(7) {
        HourlyForecast(
            descriptor = "Cloudy",
            icon = Icons.Filled.WbCloudy,
            hour = "19:00",
            temperature = "20"
        )
    }
    WeatherAppTheme (darkTheme = true) {
        HourlyForecastSheet(hourlyForecast = forecast)
    }
}