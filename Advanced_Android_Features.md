## Advanced Android Features

* List Views

  activity_main.xml --> ListView

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


* Multiplication table with listView
  * with seekbar and listView
  1. set the default seekbar position and the max / min position of seekbar
  2. set the change listener of the seekbar
     * the default value of seekbar cannot smaller/larger than min value
     * add the result to arrayList  (tableContent)
     * show the result with arrayAdapter 
  
  ```java
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
          seekBar.setProgress(startingPosition); // set the default position
  
  
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
  ```
  
* Timers

  * Do timing functions
  * Android 提供了很多執行緒的方法(e.g Thread, AsyncTask,etc)，Handler 操作 Runnable是其中一種，將  Handler 想像為處理器，而 Runnable 為被處理的事件，一個處理器可以處理很多事件。
  * Handler : allow us to do some timing functions 
  * Runnable :  執行續的啟動

  ```java
  package com.example.timers;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.os.Bundle;
  import android.os.CountDownTimer;
  import android.os.Handler;
  import android.util.Log;
  
  public class MainActivity extends AppCompatActivity {
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          
          Handler handler = new Handler();
          Runnable run = new Runnable() {
              @Override
              public void run() {
                  Log.i("Hey ", "A second passed");
                  // 1秒執行一次 run()
                  handler.postDelayed(this, 1000);
              }
          };
          handler.post(run);
      }
  }
  ```

* Count Down Timer

  * Use another method to create count down timer

    ```java
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
    ```

* Showing and Hiding UI elements (enable and disable elements when sth is trigger)

  https://stackoverflow.com/questions/5052288/how-can-i-hide-show-an-element-when-a-button-is-pressed

  1. find the things you want to hide/show, name it with id
  2. use findViewById(id) to find the thing
  3. use onClickListener() to help with trigger
  4. setVisibility

  ```java
  package com.example.show_hide;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.os.Bundle;
  import android.view.View;
  import android.widget.TextView;
  
  public class MainActivity extends AppCompatActivity {
  
      TextView textView;
  
      public void show(View view) {
          textView.setVisibility(View.VISIBLE);
      }
  
      public void hide(View view) {
          textView.setVisibility(View.INVISIBLE);
      }
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
  
          // find the textView with its id
          textView = findViewById(R.id.text);
      }
  }
  ```

* Downloading Web Content
  * Get the HTML data on the background, instead of main thread
  * Keep the app responsive
  * threads are basically just where work happens in an app
  * The example below will download the source code of the website

  
  * ```java
    package com.example.download_web_content;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.util.Log;

    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.MalformedURLException;
    import java.net.URL;

    public class MainActivity extends AppCompatActivity {

        // Run the task in the background
        public class downloadTask extends AsyncTask<String, Void, String> {

            @Override
            // String... --> String array
            protected String doInBackground(String... urls) {
                String result = "";
                // URL objects, input must be URL, otherwise error is appeared
                URL url;
                HttpURLConnection urlConnection = null;

                // if the input is not URL, exceptions will be triggered.
                try {
                    url = new URL(urls[0]);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream(); // get the input
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    int data = inputStreamReader.read(); // read the data

                    while(data != 1) {
                        char current = (char) data;
                        result += current;
                        data = inputStreamReader.read();
                    }
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return "Failed";
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Failed";
                }

            }
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            downloadTask task = new downloadTask();
            String result = null;
            try {
                result = task.execute("https://www.zappycode.com").get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.i("Result", result);
        }
    }
    ```
    * You will find error **Permission denied (missing INTERNET permission?)** after running this.
    * We need to allow the app to use the Internet.
    * manifests --> AndroidManifests.xml
      * uses-permission android:name="android.permission.INTERNET"