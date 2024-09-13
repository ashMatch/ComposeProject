package com.jellyfish.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter
//import coil.compose.rememberAsyncImagePainter //Para imagens web
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jellyfish.composeproject.ui.theme.ComposeProjectTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MassCalculatorApp()
        }
    }

    @Composable
    private fun MassCalculatorApp() {
        var heightInput by remember { mutableStateOf("") }
        var weightInput by remember { mutableStateOf("") }
        var result by remember { mutableStateOf<Int?>(null) }
        var isSubmitted by remember { mutableStateOf(false) }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (!isSubmitted){
                // Inputs para altura e peso
                BasicTextField(
                    value = heightInput,
                    onValueChange = {heightInput = it},
                    textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                BasicTextField(
                    value = weightInput,
                    onValueChange = {weightInput = it},
                    textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Button(onClick = {
                    // Conversão dos valores de entrada e cálculo da massa
                    val height = heightInput.toIntOrNull() ?: 0
                    val weight = weightInput.toIntOrNull() ?: 0
                    result = height*weight
                    isSubmitted = true
                }) {
                    Text("Calcular")

                }
            } else {
                // Exibindo os valores inseridos e o resultado do cálculo
                Text("Altura: $heightInput", fontSize = 20.sp)
                Text("Peso: $weightInput", fontSize = 20.sp)
                Text("Massa: ${result ?: 0}", fontSize = 24.sp, color = Color.Blue)

                // Exibição da imagem logo abaixo do resultado
                Image(
                    painter = painterResource(id = R.drawable.inuyasha),
                    contentDescription =null,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(150.dp)
                )
            }
        }

    }
}
