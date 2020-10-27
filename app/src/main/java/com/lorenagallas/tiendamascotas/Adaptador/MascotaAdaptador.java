package com.lorenagallas.tiendamascotas.Adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.lorenagallas.tiendamascotas.POJO.Mascota;
import com.lorenagallas.tiendamascotas.R;
import com.lorenagallas.tiendamascotas.db.ConstructorMascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public  MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    public MascotaAdaptador(ArrayList<Mascota> mascotas, FragmentActivity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false); //asocia layout con RecyclerView
        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvLike.setText(mascota.getLike() +"Likes");

        mascotaViewHolder.btnLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(activity, "Diste like a " + mascota.getNombre() , Toast.LENGTH_SHORT).show();

                ConstructorMascota constructorMascotas = new ConstructorMascota(activity);
                constructorMascotas.darLikeMascotas(mascota);
                mascotaViewHolder.tvLike.setText(String.valueOf(constructorMascotas.obtenerLikesMascotas(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvLike;
        private ImageButton btnLink;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto  = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLike   = (TextView) itemView.findViewById(R.id.tvlikeCV);
            btnLink  = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}