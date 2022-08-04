package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayFromDB extends AppCompatActivity {
        LinearLayout container;
        DBhelper dBhelper;
        LayoutInflater layoutInflater;
        ImageView edit, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_from_db);

        container = findViewById(R.id.containn);
        dBhelper = new DBhelper(this);
        layoutInflater = LayoutInflater.from(this);

        Cursor cursor = dBhelper.fetchData();
        while (cursor.moveToNext()){
            View view = layoutInflater.inflate(R.layout.singleuser,container,false);

            TextView nametxt = view.findViewById(R.id.name);
            TextView gradetxt = view.findViewById(R.id.grade);
            ImageView imageview = view.findViewById(R.id.check);
            delete = view.findViewById(R.id.delete);
            edit = view.findViewById(R.id.edit);
            @SuppressLint("Range")
            String id = cursor.getString(cursor.getColumnIndex("ID"));

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    deleteuser(id, view);
                }
            });

            @SuppressLint("Range")
            String name = cursor.getString(cursor.getColumnIndex("ID"));
            @SuppressLint("Range")
            String grade = cursor.getString(cursor.getColumnIndex("GRADE"));
            @SuppressLint("Range")
            String username = cursor.getString(cursor.getColumnIndex("USERNAME"));

            nametxt.setText(name);
            gradetxt.setText(grade);
            if(grade.trim().equals("failed")){
                imageview.setImageResource(R.drawable.ic_cancel_24);
            }else{imageview.setImageResource(R.drawable.ic_baseline_check_24);}


            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DisplayFromDB.this, UpdateDB.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("grade", grade);
                    bundle.putString("name", name);
                    bundle.putString("id",id);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            container.addView(view);
        }


    }
    public void deleteuser(String id, View view){
        AlertDialog.Builder alertbuilder;
        alertbuilder = new AlertDialog.Builder(this);
        alertbuilder.setMessage("You are about to delete this content");
        alertbuilder.setCancelable(false);

        alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean status = dBhelper.delete(id);

                Toast.makeText(DisplayFromDB.this, String.valueOf(status)+ id, Toast.LENGTH_SHORT).show();
                container.removeView(view);
            }
        });
        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DisplayFromDB.this, "User was not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertbuilder.create();
        alertDialog.setTitle("Deleting Dialog");
        alertDialog.show();


    }
}