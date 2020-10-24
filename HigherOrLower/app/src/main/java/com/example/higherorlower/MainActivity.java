package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    int rand_int;

    public void clickFunction(View view) {
        String msg = "";
        EditText num = (EditText) findViewById(R.id.editText);

        if (num.getText().toString().isEmpty() == true) {
            msg = "Please enter a number";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        } else {
            int no = Integer.parseInt(num.getText().toString());
            while (rand_int != no) {
                if (no < rand_int) {
                    msg = "The number is too small";
                    Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
                } else if (no > rand_int) {
                    msg = "The number is too big";
                    Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
                }
            }
            if (rand_int == no) {
                msg = "You guess the correct number";
                Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rand = new Random();
        rand_int = rand.nextInt(20) + 1; // 1-20

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}