package com.lorenagallas.tiendamascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.provider.CallLog;

import com.lorenagallas.tiendamascotas.POJO.Mascota;
import com.lorenagallas.tiendamascotas.R;

import java.util.ArrayList;

public class ConstructorMascota {

    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorMascota(Context context){
        this.context = context;
    }
    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return  db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Manola");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Ramiro");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.oveja);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Mario");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.colibri);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Karina");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.vaca);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Sabrina");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.mariposa);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Anahi");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.pajaro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nemo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.pez);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Liam");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.pajaro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Ibi");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.perro);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascotas(Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_NUMERO, LIKE);
        db.insertarLikesMascota(contentValues);
    }


    public int obtenerLikesMascotas(Mascota mascota){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
