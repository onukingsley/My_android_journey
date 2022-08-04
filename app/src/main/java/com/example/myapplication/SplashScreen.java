package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
ImageView imageView;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView = findViewById(R.id.view);
        textView = findViewById(R.id.text);
        slideinleft(imageView);
        slideinright(textView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },1500);

    }
    private  void slideinleft(View view){
        AlphaAnimation fadein = new AlphaAnimation(0,1);
        final AnimationSet set = new AnimationSet(false);
        Animation infromleft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,-1.0f,
                Animation.RELATIVE_TO_PARENT,0.0f,
                Animation.RELATIVE_TO_PARENT,0.0f,
                Animation.RELATIVE_TO_PARENT,0.0f
        );
        set.addAnimation(fadein);
        set.addAnimation(infromleft);
        set.setDuration(1000);
        set.setStartOffset(100);
        view.startAnimation(set);
    }
    private  void slideinright(View view){
        AlphaAnimation fadein = new AlphaAnimation(0,1);
        final AnimationSet set = new AnimationSet(false);
        Animation infromright = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,1.0f,
                Animation.RELATIVE_TO_PARENT,0.0f,
                Animation.RELATIVE_TO_PARENT,0.0f,
                Animation.RELATIVE_TO_PARENT,0.0f
        );
        set.addAnimation(fadein);
        set.addAnimation(infromright);
        set.setDuration(1000);
        set.setStartOffset(100);
        set.setInterpolator(new AccelerateInterpolator());
        view.startAnimation(set);
    }
}
