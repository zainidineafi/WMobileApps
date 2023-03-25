package com.example.project.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project.Models.Mahasiswa;
import com.example.project.R;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    private List<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item_mahasiswa, parent, false);
        return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa mahasiswa = mahasiswaList.get(position);
        holder.namaMahasiswa.setText(mahasiswa.getNama());
        holder.nimMahasiswa.setText(mahasiswa.getNim());
        holder.prodiMahasiswa.setText(mahasiswa.getProdi());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public static class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        public TextView namaMahasiswa;
        public TextView nimMahasiswa;
        public TextView prodiMahasiswa;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMahasiswa = itemView.findViewById(R.id.nama_mahasiswa);
            nimMahasiswa = itemView.findViewById(R.id.nim_mahasiswa);
            prodiMahasiswa = itemView.findViewById(R.id.prodi_mahasiswa);
        }
    }
}

