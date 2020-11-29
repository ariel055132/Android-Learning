package com.example.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Currency converter demo
    // Converts from pounds to dollars which is about 1.3
    public void clickFunction(View view) {
        EditText price = (EditText) findViewById(R.id.editText);
        String value = price.getText().toString();
        int p = Integer.parseInt(value);
        double d = p * 1.3;
        String result = String.format("%.2f", d);
        Toast.makeText(this, result , Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}