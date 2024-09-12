package com.example.conversation_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopAppConversationBar()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppConversationBar(){
    //var onClick: () -> Unit = {}
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        FilledButton { }

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
        
        // a class which get username and details
        Column {
            Text(
                text = "Username"
            )
            Text(
                text = "cv"
            )
        }
        //////////////////////////////////////////

    }
}


@Composable
fun FilledButton(onClick: () -> Unit){
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