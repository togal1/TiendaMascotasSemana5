package com.lorenagallas.tiendamascotas.Fragments;

import com.lorenagallas.tiendamascotas.Adaptador.MascotaAdaptador;
import com.lorenagallas.tiendamascotas.POJO.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

        public void generarLinearLayoutVertical();
        public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
        public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);
    }

