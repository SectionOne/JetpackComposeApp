package es.cibernarium.jetpackcomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.cibernarium.jetpackcomposeapp.navegacio.NavegacioApp
import es.cibernarium.jetpackcomposeapp.navegacio.PantallesApp
import es.cibernarium.jetpackcomposeapp.pantalles.PrimeraPantalla
import es.cibernarium.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

private val perfils: List<Perfil> = listOf(
    Perfil("Enric","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Marc","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Joana","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Iria","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Helena","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Tomeu","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Simon","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Enriqueta","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Sonia","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Joan","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Lidia","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Sandra","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum."),
    Perfil("Mario","Sòc un usuari molt actiu de la plataforma. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sagittis id mi a semper. Sed tempor metus in hendrerit sagittis. Maecenas ex lorem, pretium at nulla nec, congue finibus ante. Mauris consectetur fermentum lacinia. Duis dignissim placerat elit, vel pretium libero laoreet vel. Aenean posuere, ipsum at fermentum suscipit, nibh ex pretium neque, sed elementum orci risus ac ligula. Etiam tempus id dui vitae interdum.")
)

class MainActivity : ComponentActivity() {
    lateinit var usersDBHelper: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usersDBHelper = miSQLiteHelper(this) //El contexte o scope sera this
        setContent {
            JetpackComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Tot el que posem aqui serà la part visible de la nostre Aplicació
                    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .padding(15.dp)
                            .verticalScroll(scrollState)
                    ) {
                        //PrimeraPantalla()
                        NavegacioApp(usersDBHelper)
                    }
                }
            }
        }
    }
}
    data class Perfil(val nom: String,val description: String)

    @Composable
    fun Usuaris(perfils: List<Perfil>) {
        Column {
            perfils.forEach { dades ->
                Element(dades)
            }
        }
    }
    @Composable
    fun Element(dades: Perfil){
        //Definim variable de control sobre l'estat de clickable
        //var expanded = false
        var expanded by remember{mutableStateOf(false)}
        Row {
            Avatar()
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        expanded = !expanded
                    }
            ) {
                SalutacioPersonal(nom = dades.nom)
                Description(
                    description = dades.description,
                    if (expanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
    @Composable
    fun SalutacioPersonal(nom: String){
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
    fun Avatar(){
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
    fun Description(description: String,linies: Int = Int.MAX_VALUE){
        Text(text = description, maxLines = linies)
    }
