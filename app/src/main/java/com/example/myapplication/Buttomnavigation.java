package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Buttomnavigation extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    centerFragment centert = new centerFragment();
    PersonFragment personFragment = new PersonFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttomnavigation);

        frameLayout = findViewById(R.id.containernav);
        bottomNavigationView = findViewById(R.id.BottomNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.containernav,homeFragment,"ello").commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
/*
                  switch (item.getItemId()){
                    case R.id.home:
                        return getSupportFragmentManager().beginTransaction().replace(R.id.containernav,homeFragment).;

                    case R.id.favorite:
                        return getSupportFragmentManager().beginTransaction().replace(R.id.containernav,centert);

                    case R.id.person:
                        return getSupportFragmentManager().beginTransaction().replace(R.id.containernav,personFragment);

                }*/
                if (item.getItemId() == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.containernav,homeFragment).commit();

                }
                 if (item.getItemId()== R.id.favorite){
                    getSupportFragmentManager().beginTransaction().replace(R.id.containernav,centert).commit();

                }
                 if (item.getItemId()== R.id.person){
                    getSupportFragmentManager().beginTransaction().replace(R.id.containernav,personFragment).commit();
                }
                return false;
            }


        });
    }
}