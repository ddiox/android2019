package com.example.mylistview;

import android.content.Context;
import android.print.PrintDocumentAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapater extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes;

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public HeroAdapater(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Hero hero = (Hero) getItem(position);
        viewHolder.bind(hero);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero){
                txtName.setText(hero.getName());
                txtDescription.setText(hero.getDescription());
                imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
