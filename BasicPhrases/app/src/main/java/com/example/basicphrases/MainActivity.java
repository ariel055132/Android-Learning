package com.example.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// English to French App

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public void onClick(View view) {
        Button btn = (Button) view;
        Log.i("Tag", btn.getTag().toString());


        mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(btn.getTag().toString(), "raw", getPackageName()));
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}