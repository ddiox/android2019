package com.example.musiconvinyl;

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

public class ListVinylAdapter extends RecyclerView.Adapter<ListVinylAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Vinyl> listVinyl;
    private OnNoteListener mOnNoteListener;

    public ListVinylAdapter(Context context, OnNoteListener onNoteListener) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_vinyl, viewGroup, false);
        return new CategoryViewHolder(itemRow, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tvName.setText(getListVinyl().get(i).getName());
        categoryViewHolder.tvRemarks.setText(getListVinyl().get(i).getRemarks());

        Glide.with(context)
                .load(getListVinyl().get(i).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListVinyl().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        OnNoteListener onNoteListener;

        public CategoryViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
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
