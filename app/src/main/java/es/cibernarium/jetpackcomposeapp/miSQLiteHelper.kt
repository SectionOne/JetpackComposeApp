package es.cibernarium.jetpackcomposeapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class miSQLiteHelper(context: Context):SQLiteOpenHelper (
    //context, nom bases de dades, cursores si no són estandards, versió
    context,"ciber.db",null,1) {
    //Funcions obligatories per a Sqlite
    override fun onCreate(db: SQLiteDatabase?) {
        val ordreCreacio = "CREATE TABLE users " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT," +
                "clau TEXT)"
        db!!.execSQL(ordreCreacio) //Afegim els !! per asegurar-li que no serà NULL
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Devant una actualització de versió en un entorn de test podriem borrar la taula i tornar a crearla
        val ordreBorrat = "DROP TABLE IF EXISTS users"
        db!!.execSQL(ordreBorrat)
        onCreate(db)
    }

    //Funcions complementaries
    fun afegirDades(email:String,clau:String){
        //Crearem un element ContentValues que consisteix en un mapa
        // format per conjunts de claus i valors
        val dades = ContentValues()
        dades.put("email",email) //Crearem el camp o clau nom i li asignem
        // el valor amb la variable rebuda nom
        dades.put("clau",clau)

        //Guardarem ara les dades
        val db = this.writableDatabase //Demanem accés en modo escriptura
        //Nom taula, comportament del nullColumnHack, dades
        db.insert("users",null, dades)
        db.close() //Tanquem la connexió amb la bd
    }
}