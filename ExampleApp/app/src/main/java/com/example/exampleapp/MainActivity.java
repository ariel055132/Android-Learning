package com.example.exampleapp;

// import library to allow us to use certain features of the Android OS
import androidx.appcompat.app.AppCompatActivity; // the action bar at the top and show the name of the app

import android.os.Bundle; // os bundle for the Android OS itself
import android.util.Log;
import android.view.View;

// class : a chunk of code that contains variables, function, methods (class name is MainActivity, means it is the class that controls out activity)
// public : it can be accessed from anywhere within the app
// extends : allows us to use any methods or variables within AppCompatActivity class
public class MainActivity extends AppCompatActivity {
    // create clickFunction method for button
    public void clickFunction(View view) {
        // use Logs to interact with the App, i for information, e for error
        // tag : describe the type of log entry that we are making
        // msg : the message
        Log.i("Info", "Button Pressed");
    }

    // onCreate : run when the activity is used
    // @Override : use the methods that exists in some library and adding some extra code for our use
    // protected : it can be accessed within the app but not outside the app
    // public : it can also be accessed outside the map
    // void : the functions does not return anything
    // contentView : links to the activity_main.xml (particular layout)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}