package com.example.musiconvinyl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewVinylAdapter extends RecyclerView.Adapter<CardViewVinylAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Vinyl> listVinyl;
    private OnNoteListener mOnNoteListener;

    public CardViewVinylAdapter(Context context, OnNoteListener onNoteListener) {
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
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_vinyl, viewGroup, false);
        return new CardViewViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        Vinyl v = getListVinyl().get(i);
        Glide.with(context)
                .load(v.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(v.getName());
        cardViewViewHolder.tvRemarks.setText(v.getRemarks());
        cardViewViewHolder.tvPrice.setText(v.getPrice());
        cardViewViewHolder.btnLike.setOnClickListener(new CustomOnitemClickListener(i, new CustomOnitemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Liked "+getListVinyl().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListVinyl().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvRemarks, tvPrice;
        Button btnLike, btnDetails;
        OnNoteListener onNoteListener;

        public CardViewViewHolder(@NonNull View itemView,  OnNoteListener onNoteListener) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            tvPrice= itemView.findViewById(R.id.tv_item_price);
            btnLike = itemView.findViewById(R.id.btn_set_like);
            btnDetails = itemView.findViewById(R.id.btn_set_details);
            this.onNoteListener = onNoteListener;

            btnDetails.setOnClickListener(this);
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
