package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {
Button notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notification = findViewById(R.id.notificatione);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            issueNotification();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void makeNotificationChannel(String id, String name, int importance){
        NotificationChannel channel = new NotificationChannel(id,name,importance);
        channel.setShowBadge(true);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannel(channel);
        ;

    }
    void issueNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        makeNotificationChannel("CHANNEL_1","millonaire Game", NotificationManager.IMPORTANCE_DEFAULT);

    }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,"CHANNEL_1");

        notification
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                .setContentTitle("millonaire Game")
                .setContentText("Reminder to play the game")
                .setNumber(3);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        assert  notificationManager !=null;
        notificationManager.notify(1,notification.build());



}

}