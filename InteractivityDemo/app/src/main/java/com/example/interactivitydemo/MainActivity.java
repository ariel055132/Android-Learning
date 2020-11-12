package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

// Ex : create a login page that need the username and password enter, after press the button should say log in.
public class MainActivity extends AppCompatActivity {
    public void clickFunction(View view) {
        // get the value of the name / Password input by user
        EditText userName = (EditText)findViewById(R.id.userName);
        EditText pwd = (EditText)findViewById(R.id.passWord);
        String user = userName.getText().toString();
        String password = pwd.getText().toString();

        boolean hasName = true;
        boolean hasPassword = true;

        // Check whether username and password is inputed
        if (user.isEmpty()) {
            hasName = false;
        } else if (password.isEmpty()) {
            hasPassword = false;
        }

        if (hasName && hasPassword) {
            Log.i("Success", "Log in");

        } else {
            Log.i("Fail" , "Input username and password");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}