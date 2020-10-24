package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;
        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void clickFunction(View view) {
        //Log.i("Button", "is Pressed");
        Number num = new Number();
        EditText no = (EditText) findViewById(R.id.editTextNumber);
        String message = "";
        if (no.getText().toString().isEmpty() == true) {
            message = "Please enter a number";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            num.number = Integer.parseInt(no.getText().toString());
            boolean tri = num.isTriangular();
            boolean sq = num.isSquare();
            if (tri == true && sq == true) {
                message = "The number is triangular number and square number.";
            } else if (tri == true && sq == false) {
                message = "The number is triangular number";
            } else if (tri == false && sq == true) {
                message = "The number is square number";
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}