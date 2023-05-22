package com.example.remoteservermanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remoteservermanager.ui.theme.RemoteServerManagerTheme
import kotlinx.coroutines.launch

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
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(topText = "Remote Server Manager", onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        drawerContent = {
                        MenuDrawer()
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
fun TopBar(topText: String, onNavigationIconClick: () -> Unit){
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
                onClick = onNavigationIconClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },

        backgroundColor = Color(49,62,79),
        contentColor = Color.LightGray
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
    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Card(backgroundColor = Color.White,
//        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .fillMaxWidth()
//            .padding(horizontal = 5.dp))
        )
    {
        Divider()
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
                    onClick = { showMenu = !showMenu}
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More"
                    )
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false} ) {
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Start")
                        }
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Stop")
                        }
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Manage")
                        }
                    }
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
        Divider()
    }
}
@Composable
fun MenuDrawer(){
    Column(){
        MenuDrawerHeader()
        MenuDrawerContent(items = listOf(
                                MenuItem(
                                id = "settings",
                                title = "Settings",
                                contentDescription = "Settings button",
                                icon = Icons.Default.Settings
                                ),
                                MenuItem(
                                id = "info",
                                title = "Info",
                                contentDescription = "Info button",
                                icon = Icons.Default.Info
                                ),
                          ),
                          onItemCLick = {/*Ovdje navigaciju konfigurisati sa when: it.id="nesto" -> navigateToblabla*/})
    }
}
@Composable
fun MenuDrawerHeader(){
    val logo = painterResource(id = R.drawable.main_logo)
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        Image(painter = logo, contentDescription = "App logo")
        Text(text = "Remote Server Manager", fontSize = 14.sp, color = Color.Gray)
//        Divider(Modifier.padding(vertical = 5.dp))
    }

}
@Composable
fun MenuDrawerContent(items: List<MenuItem>, modifier: Modifier = Modifier, onItemCLick: (MenuItem) -> Unit){
    LazyColumn(
        modifier
            .fillMaxSize()
            ) {
        items(items){ item ->
            Row(modifier = modifier
                .clickable { onItemCLick(item) }
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)) {
                Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                Text(text = item.title, modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp))
            }
            Divider(modifier = modifier.padding(horizontal = 16.dp))
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