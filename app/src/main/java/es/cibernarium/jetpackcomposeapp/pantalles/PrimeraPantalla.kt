package es.cibernarium.jetpackcomposeapp.pantalles

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import es.cibernarium.jetpackcomposeapp.navegacio.PantallesApp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PrimeraPantalla(navController: NavController){
    //Scaffold {
        ContingutCos(navController)
    //}
}

@Composable
fun ContingutCos(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Intranet")
        Button(onClick = {
            navController.navigate(route = PantallesApp.SegonaPantalla.route + "/Text enviat")
        }) {
            Text("Navega")
        }
        Button(onClick = {
            navController.navigate(route = PantallesApp.LoginScreen.route)
        }) {
            Text("Zona Privada")
        }
    }
}