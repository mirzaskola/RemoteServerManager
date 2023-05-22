package com.example.remoteservermanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remoteservermanager.ui.theme.RemoteServerManagerTheme
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.charts.LineChart
import kotlinx.coroutines.launch



class ServerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteServerManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ServerScreen()
                }
            }
        }
    }
}


@Composable
fun ServerScreen(modifier: Modifier = Modifier) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(topText = "Server 1", onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        content = { paddingValues ->
            Box(modifier = modifier.padding(paddingValues)) {
                Content()
            }
        },
        bottomBar = { BottomBar()},

    )
}
@Composable
fun Content(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            HardwareCard(title = "", description = "", id = )
            HardwareCard(title = "", description = "")
        }
        Row() {
            HardwareCard(title = "", description = "")
            HardwareCard(title = "", description = "")
        }
    }

}
@Composable
fun ResourseUsageImage(@DrawableRes id: Int, description: String){
    val image = painterResource(id = id)
    Image(painter = image, contentDescription = description)
}
@Composable
fun HardwareCard(@DrawableRes id: Int, modifier: Modifier = Modifier, title: String, description: String){
    val image = painterResource(id = id)
    Column(modifier = modifier
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "RAM")
        Text(text = "Mjau")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RemoteServerManagerTheme {
        ServerScreen()
    }
}