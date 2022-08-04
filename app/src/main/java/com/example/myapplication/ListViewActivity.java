package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    MylistviewAdapter mylistviewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listview);

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
        names.add("kingsley"); grades.add("good");names.add("lucky"); grades.add("passed");
        names.add("john"); grades.add("failed");
        names.add("micheal"); grades.add("successful");
        names.add("jamie"); grades.add("failed");
        names.add("kingsley"); grades.add("good");names.add("lucky"); grades.add("passed");
        names.add("john"); grades.add("failed");
        names.add("micheal"); grades.add("successful");
        names.add("jamie"); grades.add("failed");
        names.add("kingsley"); grades.add("good");names.add("lucky"); grades.add("passed");
        names.add("john"); grades.add("failed");
        names.add("micheal"); grades.add("successful");
        names.add("jamie"); grades.add("failed");
        names.add("kingsley"); grades.add("good");

        mylistviewAdapter = new MylistviewAdapter(ListViewActivity.this,names,grades);
        listView.setAdapter(mylistviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bun  = new Bundle();

                /*bun.putString( (names.get(i)).toString());*/

                Intent intent   =  new Intent(ListViewActivity.this,  Viewpage.class);
                intent.putExtras(bun);
                startActivity(intent);


            }
        });
        /*String[] names = {"omega","kingsley","nnamdi"};
        ArrayAdapter r = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item,names);
        listView.setAdapter(r);  ......for a simple listadapter*/
    }
}