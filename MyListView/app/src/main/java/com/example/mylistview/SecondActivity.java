package com.example.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView detail_name, detail_description;
    ImageView detail_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        detail_name = findViewById(R.id.detail_txt_name);
        detail_description = findViewById(R.id.detail_txt_description);
        detail_photo = findViewById(R.id.detail_img_photo);

        String hero_name = getIntent().getStringExtra("name");
        String hero_description = getIntent().getStringExtra("description");
        int hero_photo = getIntent().getIntExtra("photo", 0);

        detail_name.setText(hero_name);
        detail_description.setText(hero_description);
        detail_photo.setImageResource(hero_photo);
    }
}
