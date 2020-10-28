package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

// 1. Play, Pause button
// 2. Volume control
// 3. Sound effect time control

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    // Control system for the audio
    public void play(View view) {
        mediaPlayer.start();
    }

    public void pause(View view) {
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use the system service to fulfill audio request
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // get the maximum volume of the device, it may not be 100
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // get the current volume
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // When the user press pause but there is nothing to be played, the app will crash (Bug)
        // Default there is some audio running in the app
        mediaPlayer = MediaPlayer.create(this, R.raw.bicycle_bell_ring);

        //int minVolume = audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC);
        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeSeekBar);
        volumeControl.setMax(maxVolume);
        // Set the current volume
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Sth changed on the seek bar
            // int progress : the value of the seekbar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Volume Seekbar changed", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            // Users start touching the seek bar
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            // Users stop touching the seek bar
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Scrub Seekbar
        SeekBar scrubControl = (SeekBar) findViewById(R.id.scrubSeekBar);
        // we can scrub to the end of the song but not other
        scrubControl.setMax(mediaPlayer.getDuration());

        scrubControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Scrub Seekbar changed", Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();
            }
        });

        // Allow us to do something every second every minute every hour while our app is running
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubControl.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0, 300);
    }
}