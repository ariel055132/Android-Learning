package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        // Anchor the controller to the video
        mediaController.setAnchorView(videoView);
        // Allow the mediaController to control the videoView
        videoView.setMediaController(mediaController);

        videoView.start();
    }
}