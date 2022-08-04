package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LayoutInflaterActivity extends AppCompatActivity {

        LinearLayout layout;
        LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_inflater);

        layout = findViewById(R.id.container);
        layoutInflater = LayoutInflater.from(this);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> grades = new ArrayList<>();

        names.add("lucky"); grades.add("passed");
        names.add("john"); grades.add("failed");
        names.add("micheal"); grades.add("successful");
        names.add("jamie"); grades.add("failed");
        names.add("kingsley"); grades.add("good");
        names.add("lucky"); grades.add("passed");
        names.add("john"); grades.add("failed");
        names.add("micheal"); grades.add("successful");
        names.add("jamie"); grades.add("failed");
        names.add("kingsley"); grades.add("good");names.add("lucky"); grades.add("passed");
        names.add("john"); grades.add("failed");
        names.add("micheal"); grades.add("successful");
        names.add("jamie"); grades.add("failed");

        for (int i = 0; i< names.size(); i++){
            View view = layoutInflater.inflate(R.layout.singleuser,layout,false);

            TextView nametxt = view.findViewById(R.id.name);
            TextView gradtxt = view.findViewById(R.id.grade);
            ImageView imageView = view.findViewById(R.id.check);

            nametxt.setText(names.get(i));
            gradtxt.setText(grades.get(i));

            if (grades.get(i).equalsIgnoreCase("Failed")){
                imageView.setImageResource(R.drawable.ic_cancel_24);
            }

            int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(LayoutInflaterActivity.this, "you clicked on "+ names.get(finalI), Toast.LENGTH_SHORT).show();

                    /*assignments create a new acticity and pass the bundle/data into it*/
                }
            });

            layout.addView(view);
        }

    }
}
