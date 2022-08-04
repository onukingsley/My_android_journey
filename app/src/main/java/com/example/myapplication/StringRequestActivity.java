package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class StringRequestActivity extends AppCompatActivity {
LayoutInflater layoutInflater;
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);
        layoutInflater = LayoutInflater.from(this);
        linearLayout = findViewById(R.id.contain);

        StringRequest request = new StringRequest(Request.Method.GET,"https://reqres.in/api/users?page=2",  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 Log.i("response",response);
                 populateData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error",error.getMessage().toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void populateData(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray data = jsonObject.getJSONArray("data");
            for (int i = 0; i <data.length(); i++){
                JSONObject singleuser  = data.getJSONObject(i);
                String firstname = singleuser.getString("first_name");
                String lastname = singleuser.getString("last_name");
                String email = singleuser.getString("email");
                String id = singleuser.getString("id");
                String avatar = singleuser.getString("avatar");
                View view = layoutInflater.inflate(R.layout.singleuser,linearLayout,false);
                ImageView imageView = view.findViewById(R.id.image);
                TextView txtname = view.findViewById(R.id.name);
                TextView txtlastname = view.findViewById(R.id.grade);
                txtname.setText(firstname);
                txtlastname.setText(lastname);
                Picasso.with(this).load(avatar).into(imageView);

                linearLayout.addView(view);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle =  new Bundle();
                        bundle.putString("email",email);
                        bundle.putString("id",id);
                        bundle.putString("avatar",avatar);
                        bundle.putString("firstname",firstname);
                        Intent intent = new Intent(StringRequestActivity.this,Viewpage.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });


            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}