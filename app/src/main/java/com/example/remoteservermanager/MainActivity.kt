package com.example.remoteservermanager

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remoteservermanager.ui.theme.RemoteServerManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemoteServerManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WelcomeScreen(topText = "Remote Server Manager")
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome,")
            Text(text = "Ado Gegaj!")
        }

        Column(modifier = modifier.padding(8.dp)) {
            Text(text = "Your servers:")
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            ServerCard()
            ServerCard()
            ServerCard()
        }
    }
}
@Composable
fun WelcomeScreen(topText: String, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = topText,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                        )
                },
                navigationIcon = {
                    IconButton(

                        onClick = { /* Handle navigation menu click here */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                backgroundColor = Color(49,62,79),
                contentColor = Color.LightGray
            )
        },
        content = { paddingValues -> Box(modifier = modifier.padding(paddingValues))
            Content()
        },
//      bottomBar = { BottomAppBar(
//                backgroundColor = Color(49,62,79),
//                contentColor = Color.White
//            ) {
//                BottomNavigationItem()
//                BottomNavigationItem()
//                BottomNavigationItem()
//            }
//        }
        bottomBar = { BottomBar()},
        floatingActionButton = {
            Surface(
                elevation = 10.dp,
                shape = CircleShape,
                color = Color.Black,
                border = BorderStroke(0.001.dp, Color.Black)
            ) {
                FloatingActionButton(
                    contentColor = Color.White,
                    backgroundColor = Color(0, 150, 150),
                    onClick = { /* Handle FAB click */ }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        },
//        floatingActionButton = {
//            Box(
//
//            ) {
//                FloatingActionButton(
//                    onClick = { /* Handle FAB click */ }
//                ) {
//                    Icon(Icons.Default.Add, contentDescription = "Add")
//                }
//            }
//        },
//        content = {
//            // Your screen content here
//        },
        floatingActionButtonPosition = FabPosition.Center

    )

}
@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(contentColor = Color.LightGray, elevation = 10.dp, backgroundColor = Color(49,62,79)) {
        BottomNavigationItem( icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Dashboard") }, selected = (selectedIndex.value == 0), onClick = {
                selectedIndex.value = 0
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Notifications,"")
        },
            label = { Text(text = "Alerts") }, selected = (selectedIndex.value == 1), onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") }, selected = (selectedIndex.value == 2), onClick = {
                selectedIndex.value = 2
            })
    }
}

@Composable
fun AddNewServerButton(){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { contentPadding -> Box(modifier = Modifier.padding(contentPadding))
        // Screen content
    }
}
@Composable
fun ServerCard(modifier: Modifier = Modifier){
    Card(backgroundColor = Color.Green,
         modifier = modifier
             .fillMaxWidth()
             .padding(5.dp))
    {
        Row(modifier = modifier.padding(5.dp)){
            Column() {
                Text(text = "Sever 11111111111", modifier = modifier.padding(start = 5.dp))
                Text(text = "Status: Active", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp)
                Text(text = "Type: MySQL", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp)
            }
            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "null"
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "null"
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RemoteServerManagerTheme {
        WelcomeScreen(topText = "Remote Server Manager")
    }
}