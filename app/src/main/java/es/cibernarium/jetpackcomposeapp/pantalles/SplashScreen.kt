package es.cibernarium.jetpackcomposeapp.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.cibernarium.jetpackcomposeapp.R
import es.cibernarium.jetpackcomposeapp.navegacio.PantallesApp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack() //Buidem el historial per impedir que pugui tornar el SplashScreen
        navController.navigate(PantallesApp.PrimeraPantalla.route)
    }
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