package com.example.myrecyclerviewproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdpater extends RecyclerView.Adapter<ListHeroAdpater.ListViewHolder> {
    private Context context;
    private ArrayList<Hero> heroes;

    public ListHeroAdpater(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListHeroAdpater.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup, false);
        return new ListViewHolder((itemRow));
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroAdpater.ListViewHolder listViewHolder, int i) {
        listViewHolder.tvName.setText(getHeroes().get(i).getName());
        listViewHolder.tvDescription.setText(getHeroes().get(i).getDescription());

        Glide.with(context).load(getHeroes().get(i).getPhoto()).apply(new RequestOptions().override(55, 55)).into(listViewHolder.imagePhoto);

    }

    @Override
    public int getItemCount() {
        return getHeroes().size();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription;
        ImageView imagePhoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            imagePhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
