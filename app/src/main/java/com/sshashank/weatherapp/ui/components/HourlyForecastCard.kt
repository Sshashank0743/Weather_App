package com.sshashank.weatherapp.ui.components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sshashank.weatherapp.R
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme


data class HourlyForecast(
    val descriptor: String,
    val hour: String,
    val temperature: String,
    val icon: ImageVector
)

@Composable
fun HourlyForecastCard(
    hourlyForecast: HourlyForecast,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector =  hourlyForecast.icon,
            contentDescription = hourlyForecast.descriptor,
            modifier = Modifier.size(36.dp),
            tint = Color.Gray
        )
        Text(
            text = hourlyForecast.hour,
            style = MaterialTheme.typography.body2,
            color = Black
        )
        Text(
            text = hourlyForecast.temperature,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.body1
        )
    }
}


@Preview
@Composable
fun HourlyForecastCardPreview() {
    val  hourlyForecast = HourlyForecast(
        descriptor = "Cloudy",
        icon = Icons.Filled.WbCloudy,
        hour = "19:00",
        temperature = "20"
    )
    WeatherAppTheme {
        HourlyForecastCard(hourlyForecast = hourlyForecast)
    }
}

@Preview
@Composable
fun HourlyForecastCardPreviewDark() {
    val  hourlyForecast = HourlyForecast(
        descriptor = "Cloudy",
        icon = Icons.Filled.WbCloudy,
        hour = "19:00",
        temperature = "20"
    )
    WeatherAppTheme(darkTheme = true) {
        HourlyForecastCard(hourlyForecast = hourlyForecast)
    }
}