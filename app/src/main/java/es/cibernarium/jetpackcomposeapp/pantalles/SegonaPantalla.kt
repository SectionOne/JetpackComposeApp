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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SegonaPantalla(navController: NavController, text:String?){
    //Scaffold (
        ContingutCos1(navController,text)
    //}
}

@Composable
fun ContingutCos1(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Segona Pantalla")
        text?.let {Text(it)}
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Tornar Enrere")
        }
    }
}