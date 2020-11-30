package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// List View Demo
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);
        // add some items to arrayList
        ArrayList<String> name = new ArrayList<String>();
        name.add("Adrian");
        name.add("Tony");
        name.add("Stanley");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        // Set the array adapter to the list view
        myListView.setAdapter(arrayAdapter);

        // onClickListener
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // AdapterView : the list view that we had coming through
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // parent.setVisibility(View.GONE); // When someone click on the list view, it will disappear
                Log.i("List View", name.get(position)); // get the name clicked by users and show it in the LogCat
                Toast.makeText(MainActivity.this, name.get(position) + " is clicked" , Toast.LENGTH_LONG).show();
            }
        });
    }
}