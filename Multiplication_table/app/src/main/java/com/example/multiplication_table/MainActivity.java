package com.example.multiplication_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        ListView listView = (ListView) findViewById(R.id.listView);

        int max = 20;
        int startingPosition = 10;
        // Clean Magic Numbers (Programming habit)
        seekBar.setMax(max); // maximum of multiple table
        seekBar.setProgress(startingPosition);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesNumber;
                if (progress < min) {
                    timesNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timesNumber = progress;
                }
                Log.i("SeekBar changed", Integer.toString(progress));
                ArrayList<String> tableContent = new ArrayList<String>();
                for (int i = 1; i <= 50; i++) {
                    tableContent.add(Integer.toString(i * timesNumber));
                }
                // add MainActivity before this to ensure that it points to the view instead of seek Bar
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, tableContent);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}