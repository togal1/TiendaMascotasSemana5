package com.lorenagallas.tiendamascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.lorenagallas.tiendamascotas.POJO.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context  context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS+ "("+
                ConstantesBaseDatos.TABLA_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_MASCOTAS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaMascotaHuesos = "CREATE TABLE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS + "("+
                ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_NUMERO + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" + ConstantesBaseDatos.TABLA_MASCOTAS_ID +")"+
                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaHuesos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_NUMERO+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS+
                    " WHERE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA+ "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLike(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLike(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return  mascotas;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS, null, contentValues);
        db.close();
    }
    public void insertarLikesMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_LIKES_MASCOTAS, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT( "+ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA+")" +
                "FROM "+ ConstantesBaseDatos.TABLA_LIKES_MASCOTAS +
                " WHERE "+ ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + "="+ mascota.getId();
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}






