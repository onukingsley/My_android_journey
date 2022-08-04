package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Viewpage extends AppCompatActivity {
        TextView firstname;
        TextView email;
        TextView id;
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        firstname = findViewById(R.id.firstname);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);
        imageView = findViewById(R.id.imageContainer);
        Bundle bundle = getIntent().getExtras();
        firstname.setText(bundle.getString("firstname"));
        id.setText(bundle.getString("id"));
        email.setText(bundle.getString("email"));
        Picasso.with(this).load(bundle.getString("avatar")).into(imageView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}