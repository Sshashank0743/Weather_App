package com.sshashank.weatherapp.ui.components

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*
import kotlin.collections.List as List

data class Month(
    val title: String,
    val blankDates: List<BlankDate>,
    val dateForecasts: List<DateForecast>,
)
object BlankDate

data class DateForecast(
    val date: String,
    val highTemperature: String,
    val icon: ImageVector,
    val isToday: Boolean
)

@Composable
fun Calendar(
    months: List<Month>,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
) {
    val gridCellNumber = 7
    LazyVerticalGrid(
        modifier = Modifier
            .background(Color.LightGray)
            .clickable{},
        columns = GridCells.Fixed(gridCellNumber),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        months.forEach { month ->
            item(
                span = { GridItemSpan(gridCellNumber) }
            ) { MonthLabel(month = month.title)}
            items(month.blankDates) {
                BlankCard()
            }
            items(month.dateForecasts) {
                DateCard(dateForecast = it)
            }
        }
    }
}

@SuppressLint("NewApi")
@Composable
fun Calendar() {
    val months = listOf(
        Month(
            title = "July",
            blankDates = List(5) {
                BlankDate
            },
            dateForecasts = List(java.time.Month.JULY.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    highTemperature = "70",
                    icon = Icons.Filled.WbSunny,
                    isToday = it == 5
                )
            }
        ),
        Month(
            title = "August",
            blankDates = List(1) {
                BlankDate
            },
            dateForecasts = List(java.time.Month.AUGUST.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    highTemperature = "70",
                    icon = Icons.Filled.WbSunny,
                    isToday = false
                )
            }
        )
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewCalendar() {
    WeatherAppTheme {
        Calendar(months = listOf(Month(
            title = "July",
            blankDates = List(5) {
                BlankDate
            },
            dateForecasts = List(java.time.Month.JULY.length(false)) {
                DateForecast(
                    date = "${it + 1}",
                    highTemperature = "70",
                    icon = Icons.Filled.WbSunny,
                    isToday = it == 5
                )
            }
        ),
            Month(
                title = "August",
                blankDates = List(1) {
                    BlankDate
                },
                dateForecasts = List(java.time.Month.AUGUST.length(false)) {
                    DateForecast(
                        date = "${it + 1}",
                        highTemperature = "70",
                        icon = Icons.Filled.WbSunny,
                        isToday = false
                    )
                }
            )))
    }
}


@SuppressLint("NewApi")
@Composable
fun MonthLabel(
    month: String,
    modifier: Modifier = Modifier
) {
    val weekDays = listOf(
        DayOfWeek.SUNDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
    ).map {
        it.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(
            text = month,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography
                .h5
                .copy(fontWeight = FontWeight.SemiBold)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            weekDays.forEach {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.weight(1f, true)
                )
            }
        }
    }
}


@Composable
fun DateCard(
    dateForecast: DateForecast,
    modifier: Modifier = Modifier
) = Card(
    modifier = modifier,
    backgroundColor = if (dateForecast.isToday) Blue else MaterialTheme.colors.surface
){
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dateForecast.date,
            style = MaterialTheme.typography.overline,
            color = if (dateForecast.isToday) Color.White else Black,
            fontSize = 12.sp

        )
        Icon(
            imageVector = Icons.Filled.WbSunny,
            contentDescription = null,
            tint = Color(255, 179, 13),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(24.dp)
        )
        Text(
            text = dateForecast.highTemperature,

            style = MaterialTheme.typography.overline,
            color = if (dateForecast.isToday) Color.White else Black,
            fontSize = 12.sp
        )
    }
}


@Composable
fun BlankCard(modifier: Modifier = Modifier) {
    Column(modifier) {
        
    }
}