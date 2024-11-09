package es.cibernarium.jetpackcomposeapp.navegacio

sealed class PantallesApp(val route: String){
    object SplashScreen:PantallesApp("splash_screen")
    object LoginScreen:PantallesApp("login_screen")
    object PrimeraPantalla:PantallesApp("primera_pantalla")
    object SegonaPantalla:PantallesApp("segona_pantalla")
}