package com.example.musiconvinyl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class GridVinylAdapter  extends RecyclerView.Adapter<GridVinylAdapter.GridViewHolder>{
    private Context context;
    private ArrayList<Vinyl> listVinyl;
    private OnNoteListener mOnNoteListener;

    public GridVinylAdapter(Context context, OnNoteListener onNoteListener) {
        this.context = context;
        this.mOnNoteListener = onNoteListener;
    }

    public ArrayList<Vinyl> getListVinyl() {
        return listVinyl;
    }

    public void setListVinyl(ArrayList<Vinyl> listVinyl) {
        this.listVinyl = listVinyl;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_vinyl, viewGroup, false);
        return new GridViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getListVinyl().get(i).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListVinyl().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        ImageView imgPhoto;
        OnNoteListener onNoteListener;
        public GridViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
