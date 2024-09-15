package com.example.conversation_app

import com.example.conversation_app.ui.theme.SampleData
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversationUI()
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun RightMessageCard(message: Message){
    Row(
        horizontalArrangement = Arrangement.Absolute.Right,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,

            )

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}

@Composable
fun LeftMessageCard(message: Message){
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.width(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLeftMessageCard(){
    LeftMessageCard(Message("Valentin Ungureanu", "Cf, iesi?"))
}

@Preview
@Composable
fun PreviewRightMessageCard(){
    RightMessageCard(Message("Alexandru Constantin", "Da."))
}


data class Acount (val username: String, val activity: String)

@Preview(showBackground = true)
@Composable
fun TopAppConversationBar(){
    //var onClick: () -> Unit = {}
    val user = Acount("Username", "activity")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, top = 24.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        BackButton { }

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape),
        )

        Spacer(modifier = Modifier.width(8.dp))
        
        Column {
            Text(
                text = user.username
            )
            Text(
                text = user.activity
            )
        }

    }
}


@Composable
fun BackButton(onClick: () -> Unit){
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(),
    ) {
        Text(
            fontSize = TextUnit.Unspecified,
            text = "<"
        )
    }
}

@Composable
fun SentButton(onClick: () -> Unit){
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors()
    ){
        Text(
            text = ">"
        )
    }
}

@Composable
fun Conversation(messages: List<Message>){
    LazyColumn {
        items(messages){
            message ->
                if(message.author == "Alex"){
                    RightMessageCard(message)
                }else{
                    LeftMessageCard(message)
                }
        }
    }
}


@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Preview
@Composable
fun PreviewOutlinedTextFieldSample(){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        label = {Text("Label")}
    )
}

@Preview(showBackground = true)
@Composable
fun BottomConversationAppBar(){

}

@Preview(showBackground = true)
@Composable
fun ConversationUI(){
    Column {
        TopAppConversationBar()
        Conversation(SampleData.conversationSample)
        // possible a spacer between Conversation and bottom bar
        BottomConversationAppBar()
    }

}










