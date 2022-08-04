package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
        Button button ;
        Button alertDialog;
        Button stringrequest;
        Button listview;
        Button sharepreference;
        Button btnadapter;
        Button menu;
        Button bottomnav;
        Button imagepicker;
        Button tabview;
        Button login;
        DrawerLayout drawerLayout;
        NavigationView navigationView;
        public ActionBarDrawerToggle actionBarDrawerToggle;
        Toolbar toolbar;


        /*deals with anything concerning the selected item*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
       /*this is mostly used for the option on the toolbar*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn1);
        alertDialog = findViewById(R.id.alertdialog);
        listview = findViewById(R.id.listview);
        btnadapter = findViewById(R.id.layoutinflater);
        menu = findViewById(R.id.menu);
        tabview = findViewById(R.id.Tabview);
        login = findViewById(R.id.loginbtn);
        sharepreference = findViewById(R.id.sharepreferencebtn);
        bottomnav = findViewById(R.id.BottomNav);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        stringrequest = findViewById(R.id.api);
        imagepicker = findViewById(R.id.imagepicker);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);



        /*navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });*/



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SimpleBrowser.class);
                startActivity(i);
            }
        });
        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AlertDialogActivity.class);

                startActivity(i);
            }
        });
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(i);
            }
        });

        btnadapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LayoutInflaterActivity.class);
                startActivity(i);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });
        bottomnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Buttomnavigation.class);
                startActivity(i);
            }
        });
        tabview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this, TabViewActivity.class);
                startActivity(i);
            }
        });
        stringrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this, StringRequestActivity.class);
                startActivity(i);
            }
        });
        imagepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(MainActivity.this, ImagePicker.class);
                startActivity(i);
            }
        });
        sharepreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SharePreferenceActivity.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddToDB.class);
                startActivity(i);
            }
        });


/*Naviation area*/
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_account){
                    Intent i = new Intent(MainActivity.this,ListViewActivity.class);
                    startActivity(i);
                }
                /*or you can use switch method*/
                switch (item.getItemId()){
                    case R.id.nav_settings:
                        Intent i = new Intent(MainActivity.this,ListViewActivity.class);
                        startActivity(i);
                }

                return false;
            }
        });
    }

    public void notification(View view) {
        Intent i = new Intent(MainActivity.this,Notification.class);
        startActivity(i);
    }

}