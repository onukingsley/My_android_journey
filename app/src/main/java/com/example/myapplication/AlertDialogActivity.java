package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btn;
    AlertDialog.Builder alertbuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btn = findViewById(R.id.show_dialog);
        alertbuilder= new AlertDialog.Builder(this);
        alertbuilder.setMessage("you are about to delete this Content");
        alertbuilder.setCancelable(false);
        alertbuilder.setIcon(R.drawable.ic_baseline_add_alert_24);

        alertbuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "you clicked no",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        alertbuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "you clicked yes",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = alertbuilder.create();
                alertDialog.setTitle("Deleting dialog");
                alertDialog.show();
            }
        });
    }
}