package com.sshashank.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sshashank.weatherapp.ui.theme.WeatherAppTheme
import androidx.compose.foundation.layout.Column as Column

data class CurrentCondition(
    val conditionTitle: String,
    val conditionValue: String
)

@Composable
fun CurrentConditionCard(
    currentCondition: CurrentCondition,
    modifier: Modifier = Modifier

) = Card(
    modifier = modifier,
    backgroundColor = MaterialTheme.colors.primary
) {
    Column(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentCondition.conditionTitle,
            style = MaterialTheme.typography.caption,
            color = Gray
        )
        Text(
            text = currentCondition.conditionValue,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}

@Composable
fun CurrentConditionRow(
    currentConditions: List<CurrentCondition>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        currentConditions.forEach {
            Spacer(modifier = Modifier.width(16.dp))
            CurrentConditionCard(
                currentCondition = it,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}


@Preview
@Composable
fun PreviewCurrentConditionCard() {
    WeatherAppTheme {
        CurrentConditionCard(currentCondition = CurrentCondition("Wind", "234"))
    }
}

@Preview
@Composable
fun PreviewDarkCurrentConditionCard() {
    WeatherAppTheme(darkTheme = true) {
        CurrentConditionCard(currentCondition = CurrentCondition("Wind", "234"))
    }
}



@Preview
@Composable
fun PreviewCurrentConditionRow() {
    val currentConditions = listOf(
        CurrentCondition("Wind", "234"),
        CurrentCondition("Temp", "16"),
        CurrentCondition("Humidity", "23%")
    )
    WeatherAppTheme {
        CurrentConditionRow(currentConditions = currentConditions)
    }
}