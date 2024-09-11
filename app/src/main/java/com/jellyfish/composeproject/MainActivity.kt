package com.jellyfish.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jellyfish.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyScreen()
            Counter()
        }
    }
}

@Composable
fun MessageCard(name:String){
    Text(text = "Olá $name")

}

//@Composable
//fun MyScreen(){
//    Column {
//        MessageCard("Ladino")
//        MessageCard("Mago")
//    }
//}

@Composable
fun Counter(){
    var count by remember { mutableStateOf(0) }

    Column {
        Text(text = "Contador: $count")
        Button(
            onClick = { count++},
            modifier = Modifier.padding(50.dp)
            ) {
            Text(text = "Aumentar")
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Fala tu $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeProjectTheme {
//        Greeting("Vagabundo")
//    }
//}