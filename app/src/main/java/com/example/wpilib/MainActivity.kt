package com.example.wpilib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wpilib.ui.theme.WpilibTheme
import edu.wpi.first.networktables.ConnectionInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // use of the WPILib:
        var conInfo = ConnectionInfo("localhost", "127.0.0.1", 8080, 0, 1)

        setContent {
            WpilibTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PrintConnectionInfo(conInfo)
                }
            }
        }
    }
}

@Composable
fun PrintConnectionInfo(conInfo: ConnectionInfo, modifier: Modifier = Modifier) {
    Text(
            text = "Remote id: ${conInfo.remote_id}\nRemote ip: ${conInfo.remote_ip}\nRemote port: ${conInfo.remote_port}\n Protocol version: ${conInfo.protocol_version}",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var conInfo = ConnectionInfo("localhost", "127.0.0.1", 8080, 0, 1)
    WpilibTheme {
        PrintConnectionInfo(conInfo)
    }
}