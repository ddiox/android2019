package com.example.myrecyclerviewproject;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;
    RecyclerView rvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepare();
        rvHeroes = findViewById((R.id.rv_heroes));
        rvHeroes.setHasFixedSize(true);

        showListRecycvler();
    }

    private void showListRecycvler() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdpater adapter = new ListHeroAdpater(this);
        addItem();
        adapter.setHeroes(heroes);
        rvHeroes.setAdapter(adapter);
    }

    private void addItem(){
        heroes = new ArrayList<>();
        for(int i = 0; i< dataName.length; i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            heroes.add(hero);

        }
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

    }
}
