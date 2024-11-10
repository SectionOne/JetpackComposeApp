package es.cibernarium.jetpackcomposeapp.navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import es.cibernarium.jetpackcomposeapp.miSQLiteHelper
import es.cibernarium.jetpackcomposeapp.pantalles.LoginScreen
import es.cibernarium.jetpackcomposeapp.pantalles.PrimeraPantalla
import es.cibernarium.jetpackcomposeapp.pantalles.SegonaPantalla
import es.cibernarium.jetpackcomposeapp.pantalles.SplashScreen

@Composable
fun NavegacioApp(usersDBHelper: miSQLiteHelper){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PantallesApp.SplashScreen.route) {
        composable(route = PantallesApp.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = PantallesApp.LoginScreen.route) {
            LoginScreen(navController,usersDBHelper)
        }
        composable(route = PantallesApp.PrimeraPantalla.route) {
            PrimeraPantalla(navController)
        }
        composable(route = PantallesApp.SegonaPantalla.route + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })
        ) {
            SegonaPantalla(navController,it.arguments?.getString("text"))
        }
    }
}