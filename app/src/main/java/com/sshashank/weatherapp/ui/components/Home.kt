package com.sshashank.weatherapp.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.sshashank.weatherapp.ui.screen.CalendarScreenPage
import com.sshashank.weatherapp.ui.screen.HomeScreenPage
import com.sshashank.weatherapp.ui.screen.SettingsScreenPage


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage() {
    val pagerState = rememberPagerState()
    var selectedScreen: Screen by remember { mutableStateOf(Screen.Home) }

    LaunchedEffect(pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            when(page) {
                0 -> selectedScreen = Screen.Home
                1 -> selectedScreen = Screen.Calendar
                2 -> selectedScreen = Screen.Settings
            }
        }
    }

    var scrollingPage: Screen by remember { mutableStateOf(Screen.Home) }
    LaunchedEffect(scrollingPage) {
        if(scrollingPage != selectedScreen) {
            pagerState.animateScrollToPage(getIndexForScreen(scrollingPage))
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HorizontalPager(
            count = 3,
            modifier = Modifier.weight(1f),
            state = pagerState,
        ) {
            when(it) {
                0 -> HomeScreenPage()
                1 -> CalendarScreenPage()
                2 -> SettingsScreenPage()
            }
        }
        Navigation(
            selectedScreen = selectedScreen,
            onSelectItem = {
                scrollingPage = it
            }
        )
    }
}

fun getIndexForScreen(screen: Screen): Int {
    return when(screen) {
        Screen.Home -> 0
        Screen.Calendar -> 1
        Screen.Settings -> 2
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewHomePage() {
    HomePage()
}
