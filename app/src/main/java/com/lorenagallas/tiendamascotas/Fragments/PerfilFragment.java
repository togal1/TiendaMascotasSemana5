package com.lorenagallas.tiendamascotas.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lorenagallas.tiendamascotas.Adaptador.PerfilAdaptador;
import com.lorenagallas.tiendamascotas.POJO.Perfil;
import com.lorenagallas.tiendamascotas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    private RecyclerView rvPerfil;
    private PerfilAdaptador perfilAdaptador;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvPerfil = v.findViewById(R.id.rvPerfil);
       // rvPerfil.setLayoutManager(new LinearLayoutManager(getActivity()));

        GridLayoutManager  glm = new GridLayoutManager(getActivity(),2);
        rvPerfil.setLayoutManager(glm);
        perfilAdaptador = new  PerfilAdaptador(obtenerPerfil());
        rvPerfil.setAdapter(perfilAdaptador);

        return v;
        // Inflate the layout for this fragment
    }

    public ArrayList<Perfil> obtenerPerfil() {
        ArrayList<Perfil> fotos = new ArrayList<>();
        fotos.add(new Perfil(R.drawable.gato, 125));
        fotos.add(new Perfil(R.drawable.gato, 236));
        fotos.add(new Perfil(R.drawable.gato, 23));
        fotos.add(new Perfil(R.drawable.gato, 198));
        fotos.add(new Perfil(R.drawable.gato, 18));
        fotos.add(new Perfil(R.drawable.gato, 112));
        fotos.add(new Perfil(R.drawable.gato, 98));
        fotos.add(new Perfil(R.drawable.gato, 9));
        fotos.add(new Perfil(R.drawable.gato, 325));

        return fotos;
    }
}