package com.sshashank.weatherapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sshashank.weatherapp.ui.components.HomePage
import com.sshashank.weatherapp.ui.components.Navigation
import com.sshashank.weatherapp.ui.screen.CalendarScreenPage
import com.sshashank.weatherapp.ui.screen.SettingsScreenPage
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Calendar : Destination("calendar")
    object Setting : Destination("setting")
}

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                HomePage()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        CalendarScreenPage()
        SettingsScreenPage()
        Navigation(
            modifier = Modifier.padding(12.dp)
            )
    }
}
