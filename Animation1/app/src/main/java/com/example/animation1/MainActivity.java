package com.example.animation1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

// A small animation
// Bart will rotate in a circle for 2 seconds
// After click the image, it will decrease in scale 0.5.

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        Log.i("Info", "ImageView tapped");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.animate().scaleX((float)0.5).scaleY((float)0.5).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setX(-1000);
        imageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);

    }
}