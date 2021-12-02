package com.example.jetpackcompose1

import android.content.ClipData
import android.content.res.Configuration
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme


private val messages: List<MyMessage> = listOf(
    MyMessage("hola 1", "como estas 1" ),
    MyMessage("hola 2", "como estas 1" ),
    MyMessage("hola 3", "como estas 1" ),
    MyMessage("hola 4", "como estas 1" ),
    MyMessage("hola 5", "como estas 1" ),
    MyMessage("hola 6", "como estas 1" ),
    MyMessage("hola 7", "como estas 1" ),
    MyMessage("hola 8", "como estas 1" ),
    MyMessage("hola 9", "como estas 1" ),
    MyMessage("hola 10", "como estas 1" ),
    MyMessage("hola 11", "como estas 1" ),
    MyMessage("hola 12", "como estas 1" ),
    MyMessage("hola 13", "como estas 1" ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose1Theme() {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
fun MyTexts(message: MyMessage){
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            text = message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewComponent(){
    JetpackCompose1Theme {

        val scrollState = rememberScrollState()

        Column(modifier = Modifier.verticalScroll(scrollState)) {
            MyMessages(messages)
        }
    }
}

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
      items(messages) {  message ->
              MyComponent(message)
      }
    }
}