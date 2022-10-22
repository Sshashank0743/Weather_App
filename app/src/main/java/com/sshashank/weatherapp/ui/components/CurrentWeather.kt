package com.sshashank.weatherapp.ui.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sshashank.weatherapp.ui.theme.Black
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme

data class CurrentWeather(
    val location: String,
    val date: String,
    val icon: ImageVector,
    val weatherDescription: String
)


@Composable
fun CurrentWeatherField(
    currentWeather: CurrentWeather,
    modifier: Modifier = Modifier
) = Column(modifier = modifier.padding(16.dp)) {
    val textColor = if (isSystemInDarkTheme()) {
        Color.Gray
    } else {
        Black
    }
    CompositionLocalProvider(LocalContentColor provides textColor) {
        Text(
            text = currentWeather.location,
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Medium
            ),
            color = textColor
        )
        Text(
            text = currentWeather.date,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Normal
            ),
            color = textColor
        )
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                imageVector = Icons.Filled.WbCloudy,
                contentDescription = null,
                tint = Color.DarkGray
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = currentWeather.weatherDescription,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xfff,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CurrentWeatherFieldPreview() {
    WeatherAppTheme {
        CurrentWeatherField(
            currentWeather = CurrentWeather(
                location = "India",
                date = "Today, 12 July",
                icon = Icons.Filled.WbCloudy,
                weatherDescription = "Lightly Cloudy"
            )
        )
    }
}