package es.cibernarium.jetpackcomposeapp.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.cibernarium.jetpackcomposeapp.R

@Composable
fun SplashScreen(){
    Splash()
}

@Composable
fun Splash(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = R.drawable.qx7jysym_400x400),
            contentDescription = "Logo Refugios Libres",
            Modifier.size(150.dp,150.dp))
        Text(text = "carregant..",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp)
    }
}