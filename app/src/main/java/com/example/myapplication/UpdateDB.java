package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateDB extends AppCompatActivity {
        EditText Name_txt, Username_txt, Grade;
        Button Update_btn;
        DBhelper dBhelper;
        FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_db);

        Name_txt = findViewById(R.id.name);
        Username_txt = findViewById(R.id.username);
        Grade = findViewById(R.id.grade);
        fab = findViewById((R.id.fab));
        Update_btn = findViewById(R.id.update);
        dBhelper = new DBhelper(UpdateDB.this);

        Bundle bundle = getIntent().getExtras();
        String name_from_table = bundle.getString("name");
        String grade_from_table = bundle.getString("grade");
        String Id_from_table = bundle.getString("id");
        String username_from_table = bundle.getString("username");

        Name_txt.setText(name_from_table);
        Username_txt.setText(username_from_table);
        Grade.setText(grade_from_table);

        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_txt = Name_txt.getText().toString();
                String username_txt = Username_txt.getText().toString();
                String grade_txt = Grade.getText().toString();

                if (name_txt.trim().isEmpty()|| username_txt.trim().isEmpty()|| grade_txt.trim().isEmpty()){
                    Toast.makeText(UpdateDB.this, "please fill in the field before you submit",Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean status = dBhelper.update(name_txt, username_txt, grade_txt, Id_from_table);
                if (status){
                    Toast.makeText(UpdateDB.this, "saved", Toast.LENGTH_SHORT).show();
                    Name_txt.setText("");
                    Username_txt.setText("");
                    Grade.setText("");
                }else{
                    Toast.makeText(UpdateDB.this, "Failed to save", Toast.LENGTH_SHORT).show();
                }

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateDB.this, DisplayFromDB.class);
                startActivity(i);
            }
        });

    }
}