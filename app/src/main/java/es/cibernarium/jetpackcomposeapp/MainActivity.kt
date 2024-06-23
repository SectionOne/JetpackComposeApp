package es.cibernarium.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import es.cibernarium.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Tot el que posem aqui serà la part visible de la nostre Aplicació
                    /*Text(
                        text = "Hello world!",
                        color = Color.Red,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )*/
                    Column {
                        Button(
                            onClick = { /*TODO*/},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.Cyan)
                        ){
                            Text(text = "Opcio 1")
                        }
                        Button(onClick = { /*TODO*/},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red, contentColor = Color.Cyan)
                        ){
                            Text(text = "Opcio 2")
                        }
                        Button(onClick = { /*TODO*/},
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Green, contentColor = Color.Cyan)
                        ){
                            Text(text = "Opcio 3")
                        }

                    }
                }
            }
        }
    }
}
