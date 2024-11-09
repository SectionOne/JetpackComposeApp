package es.cibernarium.jetpackcomposeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLOpenHelper extends SQLiteOpenHelper {
    public AdminSQLOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version); //Invoquem el constructor del pare per realitzar la connexió amb el MysqLite
    }

    //Funció de creació de la BBDD
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Executem intrucció sql per crear la taula admin
        db.execSQL("create table admin(usuario text primary key,password text)");
        String usuari = "admin";
        String clau = "123456";
        ContentValues dadesAdmin = new ContentValues();
        dadesAdmin.put("usuari",usuari);
        dadesAdmin.put("clau",clau);
        db.insert("admin","(usuari,clau)",dadesAdmin);
        db.execSQL("create table usuaris(id int primary key,nom text,genere text,pais text,provincia text,email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
