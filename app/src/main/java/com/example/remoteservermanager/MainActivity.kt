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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.platform.InspectableModifier
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
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())

        ) {
            Column() {
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
                ServerCard()
            }
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
        content = { paddingValues ->
            Box(modifier = modifier.padding(bottom = 150.dp)) {
                Content()
            }
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
                elevation = 4.dp,
                shape = CircleShape,
                color = Color.Black,
                border = BorderStroke(0.1.dp, Color.Black)
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
//@Composable
//fun ServerCard(modifier: Modifier = Modifier){
//    Card(backgroundColor = Color.Green,
//         modifier = modifier
//             .fillMaxWidth()
//             .padding(5.dp))
//    {
//        Row(modifier = modifier.padding(5.dp)){
//            Column() {
//                Text(text = "Sever 11111111111", modifier = modifier.padding(start = 5.dp))
//                Text(text = "Status: Active", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp)
//                Text(text = "Type: MySQL", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp)
//            }
//            Row(horizontalArrangement = Arrangement.End,
//                modifier = Modifier.fillMaxWidth()) {
//                Icon(
//                    modifier = modifier.padding(vertical = 10.dp),
//                    imageVector = Icons.Default.Edit,
//                    contentDescription = "null"
//                )
//                Icon(
//                    imageVector = Icons.Default.Delete,
//                    contentDescription = "null"
//                )
//            }
//        }
//    }
//}
//@Composable
//fun ServerCard(modifier: Modifier = Modifier){
//    Card(backgroundColor = Color.Green,
//         modifier = modifier
//             .fillMaxWidth()
//             .padding(5.dp))
//    {
//        Row(modifier = modifier.padding(5.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
//            Column() {
//                Text(text = "Sever 11111111111", modifier = modifier.padding(start = 5.dp))
//                Text(text = "Status: Active", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp)
//                Text(text = "Type: MySQL", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp)
//            }
//            IconButton(
//                onClick = { /* Perform your action here */ },
//                modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)
//                ) {
//                    Icon(
//                    imageVector = Icons.Default.MoreVert,
//                    contentDescription = "More"
//                )
//            }
//        }
//    }
//}
@Composable
fun ServerCard(modifier: Modifier = Modifier){
    Card(backgroundColor = Color.White,
//        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .fillMaxWidth()
//            .padding(horizontal = 5.dp))
        )
    {
        Row(modifier = modifier
            .padding(5.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
                Text(text = "Sever 11111111111", modifier = modifier.padding(start = 5.dp), fontWeight = FontWeight.Medium)
                Text(text = "Status: Active", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp, color = Color.Gray)
                Text(text = "Type: MySQL", modifier = modifier.padding(start = 5.dp), fontSize = 14.sp, color = Color.Gray)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { /* Perform your action here */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More"
                    )
                }
                IconButton(onClick = { /*TODO*/ }
                )
                   {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Execute script"
                    )
                }
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