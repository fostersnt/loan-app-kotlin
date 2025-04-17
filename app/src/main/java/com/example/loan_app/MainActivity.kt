package com.example.loan_app

//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContent {
            LoanAppScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoanAppScreen() {
    var text by remember { mutableStateOf("Welcome to my loan app!") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { text = "Button clicked!" }) {
            Text("Click Me")
        }
    }
}

