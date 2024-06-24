package es.cibernarium.jetpackcomposeapp.pantalles

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PrimeraPantalla(){
    Scaffold {
        ContingutCos()
    }
}

@Composable
fun ContingutCos(){
    Column() {
        Text("Intranet")
        Button(onClick = { /*TODO*/ }) {
            Text("Navega")
        }
    }
}

@Composable
fun VistaPrevia(){
    PrimeraPantalla()
}