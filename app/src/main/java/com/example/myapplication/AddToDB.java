package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddToDB extends AppCompatActivity {
    EditText username;
    EditText fullname;
    EditText grade;
    Button loginbtn;
    DBhelper dBhelper;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_db);

        username = findViewById(R.id.usernametxt);
        fullname = findViewById(R.id.name);
        grade = findViewById(R.id.grade);
        loginbtn = findViewById(R.id.loginbtn);
        fab = findViewById(R.id.fab);
        dBhelper = new DBhelper(AddToDB.this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernametxt = username.getText().toString();
                String fullnametxt = fullname.getText().toString();
                String gradetxt = grade.getText().toString();

                if (fullnametxt.trim().isEmpty()||usernametxt.trim().isEmpty()||gradetxt.trim().isEmpty()){
                    Toast.makeText(AddToDB.this, "Please fill all the field before you submit", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean status = dBhelper.insertIntoDB(fullnametxt,usernametxt,gradetxt);
                if (status){
                    Toast.makeText(AddToDB.this,"saved",Toast.LENGTH_SHORT);
                    username.setText("");
                    fullname.setText("");
                    grade.setText("");

                }else{
                    Toast.makeText(AddToDB.this, "Failed to saved", Toast.LENGTH_SHORT).show();
                }

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddToDB.this,DisplayFromDB.class);
                startActivity(i);
            }
        });
    }
}