package com.example.timers1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // count down timer (how many millieseconds you want timer to ultimately run for)
        // 10 seconds , interval
        new CountDownTimer(10000, 1000){
            // will be called when countDownInterval reached again
            public void onTick(long millisecondsUntilDone) {
                Log.i("Seconds Left!", String.valueOf(millisecondsUntilDone / 1000));
            }
            // run when the timer is completely done
            public void onFinish(){
                Log.i("Finish ", "No more countdown");
            }
        }.start(); // start the timer

    }
}