package es.cibernarium.jetpackcomposeapp.navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.cibernarium.jetpackcomposeapp.pantalles.PrimeraPantalla
import es.cibernarium.jetpackcomposeapp.pantalles.SegonaPantalla

@Composable
fun NavegacioApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PantallesApp.PrimeraPantalla.route) {
        composable(route = PantallesApp.PrimeraPantalla.route) {
            PrimeraPantalla(navController)
        }
        composable(route = PantallesApp.SegonaPantalla.route) {
            SegonaPantalla(navController)
        }
    }
}