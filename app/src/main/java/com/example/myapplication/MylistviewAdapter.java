package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MylistviewAdapter extends ArrayAdapter {
    ArrayList<String> names;
    ArrayList<String> grades;
    Context context;
    Activity activity;

    public MylistviewAdapter(@NonNull Context context, ArrayList<String> names, ArrayList<String> grades) {
        super(context,0,names);
        this.context = context;
        this.names = names;
        this.grades = grades;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        view = LayoutInflater.from(context).inflate(R.layout.singleuser,parent,false);

        TextView nametxt = view.findViewById(R.id.name);
        TextView gradtxt = view.findViewById(R.id.grade);
        ImageView imageView = view.findViewById(R.id.check);

        nametxt.setText(names.get(position));
        gradtxt.setText(grades.get(position));

        if (grades.get(position).equalsIgnoreCase("Failed")){
            imageView.setImageResource(R.drawable.ic_cancel_24);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "you clicked on "+ names.get(position), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context,Viewpage.class);
                context.startActivity(i);

                /*Bundle bundle = new Bundle();
                bundle.putString("key1", names.get(position));
                bundle.putString("key1", grades.get(position));*/

                /*assignments create a new acticity and pass the bundle/data into it*/
            }
        });

        return view;

    }
}
