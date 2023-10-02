package com.victorinfantes.kotlin102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorinfantes.kotlin102.ui.theme.Kotlin102Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin102Theme {
                MyApp(Modifier.fillMaxSize())
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var destino by rememberSaveable { mutableStateOf("") }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            TextAppTitle("DAM Composes UI Test")
            FlowRow {
                ButtonTest(onChange = { s: String -> destino = s }, "Una imagen")
                ButtonTest(onChange = { s: String -> destino = s }, "Una imagen apilada")
                ButtonTest(onChange = { s: String -> destino = s }, "Una lista")
                ButtonTest(onChange = { s: String -> destino = s }, "Una lista lazy")
            }
            Spacer(Modifier.padding(24.dp))
            Column {
                //Viene lo que yo quiero mostrar
                when(destino) {
                    "Una imagen" -> ImagenGenerica()
                    "Una imagen apilada" -> ImagenApilada()
                }
            }
        }
    }
}

@Composable
fun ImagenGenerica() {
    Row() {
        Text(text = "Aqui aparece una imagen")
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = "Una imagen"
        )
    }
}
@Composable
fun ImagenApilada() {
    Box(modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.android),
            contentDescription = "A image",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(modifier = Modifier.padding(32.dp, 0.dp).align(Alignment.BottomStart),
            text = "Androide",
            color = Color.White,
            fontSize = 36.dp)
    }

}

@Composable
fun ButtonTest(
    onChange: (String) -> Unit,
    textoBoton: String
) {
    Button(
        onClick = { onChange(textoBoton) },
    ) {
        Text(text = textoBoton)
    }
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Kotlin102Theme {
        MyApp(Modifier.fillMaxSize())
    }
}