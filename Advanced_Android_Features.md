## Advanced Android Features

- List Views

  ListView是開發Android常用元件之一，它能把數據用清單方式顯示出來，而ListView必須利用Adapter將資料載入，Adapter是負責管理ListView每一列的資料與畫面

  1. ArrayAdapter

     原理非常簡單：就是宣告一個陣列把要值塞進去，接著ListView就會依照順序顯示出來，因為用此方法無法讓ListView的樣式做太大的變更，因此真正開發APP時不太可能會用

     ```java
     package com.example.listview;
     import androidx.appcompat.app.AppCompatActivity;
     import android.os.Bundle;
     import android.widget.ArrayAdapter;
     import android.widget.ListView;
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
         }
     }
     ```

  2. OnItemClickListener

     通常都會搭配OnItemClickListener來使用，讓使用者點擊ListView的Item時會有一些回饋，例如跳出訊息、切換Activity..等等

     ```java
     package com.example.listview;
     import androidx.appcompat.app.AppCompatActivity;
     import android.os.Bundle;
     import android.util.Log;
     import android.view.View;
     import android.widget.AdapterView;
     import android.widget.ArrayAdapter;
     import android.widget.ListView;
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
                 }
             });
         }
     }
     ```

  3. 

