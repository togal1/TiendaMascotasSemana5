package com.lorenagallas.tiendamascotas.Presentador;

import android.content.Context;

import com.lorenagallas.tiendamascotas.Fragments.IRecyclerViewFragmentView;
import com.lorenagallas.tiendamascotas.POJO.Mascota;
import com.lorenagallas.tiendamascotas.db.ConstructorMascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascota constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,  Context  context){

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {

        constructorMascotas = new ConstructorMascota(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
