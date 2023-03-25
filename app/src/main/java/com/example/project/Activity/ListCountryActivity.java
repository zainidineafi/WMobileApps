package com.example.project.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class ListCountryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private BottomNavigationView bottomNavigationView;

    private ListView lvCountry;
    private ArrayAdapter<CharSequence> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);


        lvCountry = (ListView) findViewById(R.id.lvCountry);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_expandable_list_item_1);
        lvCountry.setAdapter(arrayAdapter);
        lvCountry.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
    }


}