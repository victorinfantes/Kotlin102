package com.victorinfantes.kotlin102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@Composable
fun MyApp (modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        TextAppTitle("DAM Composes UI Test")
    }
}




@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Kotlin102Theme {
        MyApp(Modifier.fillMaxSize())
    }
}