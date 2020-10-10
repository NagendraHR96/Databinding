package com.example.databindingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.databindingapp.adapter.HeroListAdapter;
import com.example.databindingapp.model.Hero;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    HeroListAdapter heroListAdapter;
    HeroListViewmodel heroListViewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        heroListViewmodel= ViewModelProviders.of(this).get(HeroListViewmodel.class);
        heroListViewmodel.getHeros().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(List<Hero> heroes) {
                heroListAdapter=new HeroListAdapter(heroes,MainActivity.this);
                recycler.setAdapter(heroListAdapter);
            }
        });

    }
}