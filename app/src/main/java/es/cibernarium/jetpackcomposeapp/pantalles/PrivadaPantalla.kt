package es.cibernarium.jetpackcomposeapp.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import es.cibernarium.jetpackcomposeapp.miSQLiteHelper

@Composable
fun PrivadaPantalla(navController: NavController,usersDBHelper: miSQLiteHelper){
    var llistatUsuaris = usersDBHelper.readAll()
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        for(usuari:String in llistatUsuaris){
            Text(text = usuari)
        }



    }
}