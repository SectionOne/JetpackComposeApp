package es.cibernarium.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                        Element()
                    }
                }
            }
        }
    }

    @Composable
    private fun Element(){
        Row {
            Avatar()
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                SalutacioPersonal(nom = "Francesc")
                Description()
            }
        }
    }
    @Composable
    private fun SalutacioPersonal(nom: String){
        Text(
            text = "Hola $nom!",
            color = Color.Red,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
    }
    @Composable
    private fun Avatar(){
        Image(
            painter = painterResource(R.drawable.qx7jysym_400x400),
            contentDescription = "Logo Refus",
            modifier = Modifier
                .height(100.dp)
                .clip(CircleShape)
                .background(Color.Blue)
        )
    }
    @Composable
    private fun Description(){
        Text(text = "Benvingut a la teva App de montanyisme i a on trobaràs tots els recursos a la teva disposició.")
    }
}
