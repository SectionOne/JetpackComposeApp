package es.cibernarium.jetpackcomposeapp.navegacio

sealed class PantallesApp(val route: String){
    object PrimeraPantalla:PantallesApp("primera_pantalla")
    object SegonaPantalla:PantallesApp("segona_pantalla")
}