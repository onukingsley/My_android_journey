package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SharePreferenceActivity extends AppCompatActivity {
    LinearLayout firstLayout, secondLayout;
    Button login, logout;
    EditText usertxt, passTxt;
    TextView username, password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        editor = sharedPreferences.edit();
                    /*Linearlayout and textviews*/
        firstLayout = findViewById(R.id.firstLayout);
        secondLayout = findViewById(R.id.secondlayout);
        usertxt = findViewById(R.id.usernametxt);
        passTxt = findViewById(R.id.passwordtxt);

        /*TEXTVIEWS*/
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.loginbtn);
        logout = findViewById(R.id.logoutbtn);

        ////////////////////CHECK IF THE gUY IS lOGGEDIN/////////////////////
        String user_from_sharedpreferences = sharedPreferences.getString("username", "");
        String pass_from_sharedpreferences = sharedPreferences.getString("password", "");

        ////////////////////////////Check if user has logged in////////////////////////////////////////
        if (!user_from_sharedpreferences.equals("")&& !pass_from_sharedpreferences.equals("")){
           firstLayout.setVisibility(View.GONE);
           secondLayout.setVisibility(View.VISIBLE);

            username.setText(user_from_sharedpreferences);
            password.setText(pass_from_sharedpreferences);

        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernametext = usertxt.getText().toString();
                String passwordText = passTxt.getText().toString();
                firstLayout.setVisibility(View.GONE);
                secondLayout.setVisibility(View.VISIBLE);
                editor.putString("username",usernametext);
                editor.putString("password",passwordText);
                editor.commit();
                /*challenge form validation*/

                username.setText(usernametext);
                password.setText(passwordText);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                firstLayout.setVisibility(View.VISIBLE);
                secondLayout.setVisibility(View.GONE);
            }
        });
    }
}