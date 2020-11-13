package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view) {
        EditText userName = (EditText)findViewById(R.id.userName);
        EditText pwd = (EditText)findViewById(R.id.passWord);

        Log.i("UserName", userName.getText().toString());
        Log.i("PassWord", pwd.getText().toString());
        // this refers to the app, text = string we want to output, the message to appear for a short or long length of time, .show to show the toast
        Toast.makeText(this, "Hi there", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}