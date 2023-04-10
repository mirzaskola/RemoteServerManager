package com.example.remoteservermanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    WelcomeScreen()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "REMOTE SERVER MANAGER")
        }
        Column(modifier = modifier.padding(8.dp)) {
            Text(text = "List of active servers:")
        }
        Column(modifier = modifier
            .fillMaxSize()
            .fillMaxWidth()) {
            Text(text = "SERVER 1", modifier = modifier.padding(start = 5.dp))
            Text(text = "SERVER 2", modifier = modifier.padding(start = 5.dp))
            Text(text = "SERVER 3", modifier = modifier.padding(start = 5.dp))
            Text(text = "SERVER 4", modifier = modifier.padding(start = 5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RemoteServerManagerTheme {
        WelcomeScreen()
    }
}