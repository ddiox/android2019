package com.example.musiconvinyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ListVinylAdapter.OnNoteListener, GridVinylAdapter.OnNoteListener, CardViewVinylAdapter.OnNoteListener {
    private RecyclerView rvCategory;
    private ArrayList<Vinyl> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("MusicOnVinyl List Catalog");
            list.addAll(VinylData.getListData());
            showRecyclerList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Vinyl> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            assert stateList != null;
            list.addAll(stateList);
            setMode(stateMode);
        }
    }


    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListVinylAdapter listVinylAdapter = new ListVinylAdapter(this, this);
        listVinylAdapter.setListVinyl(list);
        rvCategory.setAdapter(listVinylAdapter);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridVinylAdapter gridVinylAdapter = new GridVinylAdapter(this, this);
        gridVinylAdapter.setListVinyl(list);
        rvCategory.setAdapter(gridVinylAdapter);
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewVinylAdapter cardViewVinylAdapter = new CardViewVinylAdapter(this, this);
        cardViewVinylAdapter.setListVinyl(list);
        rvCategory.setAdapter(cardViewVinylAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "MusicOnVinyl List Catalog";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "MusicOnVinyl Grid Catalog";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "MusicOnVinyl CardView Catalog";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                showRecyclerList();
                setActionBarTitle("MusicOnVinyl List Catalog");
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                setActionBarTitle("MusicOnVinyl Grid Catalog");
                break;

            case R.id.action_cardview:
                showRecyclerCardView();
                setActionBarTitle("MusicOnVinyl CardView Catalog");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title){
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("key", list.get(position));
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, Objects.requireNonNull(Objects.requireNonNull(getSupportActionBar()).getTitle()).toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
