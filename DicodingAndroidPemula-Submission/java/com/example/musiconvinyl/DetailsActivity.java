package com.example.musiconvinyl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Vinyl vinylaccepted = getIntent().getParcelableExtra("key");
        ImageView photo = findViewById(R.id.item_photo);
        TextView name = findViewById(R.id.item_name);
        TextView nameMain = findViewById(R.id.item_name_main);
        TextView remarks = findViewById(R.id.item_remarks);
        TextView description= findViewById(R.id.item_description);
        TextView price = findViewById(R.id.item_price);

        Glide.with(this)
                .load(vinylaccepted.getPhoto())
                .into(photo);
        name.setText(vinylaccepted.getName());
        nameMain.setText(vinylaccepted.getName());
        remarks.setText(vinylaccepted.getRemarks());
        description.setText(vinylaccepted.getDescription());
        price.setText(vinylaccepted.getPrice());
    }
}
