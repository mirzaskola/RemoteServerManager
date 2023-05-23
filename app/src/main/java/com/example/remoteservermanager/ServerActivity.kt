package com.example.remoteservermanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.StopScreenShare
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val scaffoldStateServer = rememberScaffoldState()
    val scopeServer = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldStateServer,
        topBar = {
            TopBar(topText = "Server 1", onNavigationIconClick = {
                scopeServer.launch {
                    scaffoldStateServer.drawerState.open()
                }
            })
        },
        content = { paddingValues ->
            Box(modifier = modifier.padding(paddingValues)) {
                ServerContent(modifier = modifier.verticalScroll(rememberScrollState()))
            }
        },
        bottomBar = { BottomBar()},

    )
}
//@Composable
//fun Content(){
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Text(text = "Overview", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(10.dp), color = Color.Gray)
//        Divider(Modifier.padding(horizontal = 10.dp))
//        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Row(Modifier.padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
//                HardwareCard(title = "Xeons ssdfsdfs", description = "", id = R.drawable.cpu)
//                HardwareCard(title = "16GB DDR4", description = "", id = R.drawable.ram)
//                HardwareCard(title = "Samsung 970", description = "", id = R.drawable.storage)
//                HardwareCard(title = "RTX 3080", description = "", id = R.drawable.gpu)
//
//            }
//
//        }
//        Column() {
//            Text(text = "rarw")
//        }
//    }
//}
@Composable
fun ServerContent(modifier: Modifier){
    Column(modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Overview", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(10.dp), color = Color.Gray)
            Divider(Modifier.padding(horizontal = 10.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalArrangement = Arrangement.Center) {
                HardwareCard(id = R.drawable.cpu, title = "Xeon", description = "CPU type")
                HardwareCard(id = R.drawable.ram, title = "32GB DDR4", description = "RAM type")
                HardwareCard(id = R.drawable.storage, title = "Samsung", description = "Storage type")
                HardwareCard(id = R.drawable.gpu, title = "RTX 3080dsdfsdf", description = "GPU type")
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Details", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(10.dp), color = Color.Gray)
            Divider(Modifier.padding(horizontal = 10.dp))
            Column() {
                Text(text = "Type", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), color = Color.Gray)
                Text(text = "OS", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), color = Color.Gray)
                Text(text = "Location", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), color = Color.Gray)
                Text(text = "Security", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), color = Color.Gray)
                Text(text = "Kernel version", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), color = Color.Gray)
                Text(text = "Firewall", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), color = Color.Gray)

            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Actions", fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(10.dp), color = Color.Gray)
            Divider(Modifier.padding(horizontal = 10.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Start button onClick logic */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(49,62,79)),
                    modifier = Modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Start", color = Color.White)
                    }
                }

                Button(
                    onClick = { /* Stop button onClick logic */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(89,136,154)),
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Stop,
                            contentDescription = "Stop",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Stop", color = Color.White)
                    }
                }

                Button(
                    onClick = { /* Reboot button onClick logic */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(89,136,154)),
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Reload",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Reboot", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun HardwareCard(@DrawableRes id: Int, modifier: Modifier = Modifier, title: String, description: String){
    val image = painterResource(id = id)
    Column(modifier = modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = image, contentDescription = description, modifier = Modifier.size(60.dp))
        Text(text = title, softWrap = true, maxLines = 1, modifier = modifier.padding(vertical = 8.dp), overflow = TextOverflow.Ellipsis)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RemoteServerManagerTheme {
        ServerScreen()
    }
}