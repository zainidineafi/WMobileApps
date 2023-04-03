package com.example.project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project.Models.Orang;
import com.example.project.R;

import java.util.ArrayList;

public class OrangAdapter extends BaseAdapter {
    private ArrayList<Orang> listOrang;
    private Context context;

    public OrangAdapter(Context context, ArrayList<Orang> listOrang) {
        this.listOrang = listOrang;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOrang.size();
    }

    @Override
    public Orang getItem(int position) {
        return listOrang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_orang, parent, false);
        }

        Orang currentOrang = getItem(position);

        TextView namaTextView = convertView.findViewById(R.id.tv_nama11);
        TextView alamatTextView = convertView.findViewById(R.id.tv_alamat11);
        TextView teleponTextView = convertView.findViewById(R.id.tv_telepon11);

        namaTextView.setText(currentOrang.getNama());
        alamatTextView.setText(currentOrang.getAlamat());
        teleponTextView.setText(currentOrang.getTelepon());

        return convertView;
    }

    public void updateData(ArrayList<Orang> newList) {
        listOrang.clear();
        listOrang.addAll(newList);
        notifyDataSetChanged();
    }
}
