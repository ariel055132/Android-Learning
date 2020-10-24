- Textview 

- Buttons

- Text Fields

- AppCompactActivity : for activity which has an action bar at the top

- public (JAVA) : it can be accessed from anywhere

- extends : takes all the code from the extended / imported library and allows us to use any methods within the class
  
  - For example, extends AppCompactActivity means that you takes all the code from AppCompactActivity and allows you to use the methods inside the library
  
- Log.i() : show the data in 6.Logcat

- @Override : use the methods that exists in some library and adding some extra code for our use

- onCreate : the activity is created

- Device freeze, AVD Manager, choose the device, wipe out the data 

- Display messages 

- Toast (Context context, CharSequence text, int duration).show(); 
  
  - pop up, appear from the bottom (default)
  - Context : 應用程式的Context
  - CharSequence : the message you want to show
  - Duration : the exist time of the message
    - Toast.LENGTH_SHORT : 2 seconds
    - Toast.LENGTH_LONG : 3.5 seconds
  
  ```java
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.widget.Toast;
  public class MainActivity extends AppCompatActivity {
     	// demo Toast
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          Toast.makeText(this, "Toast 基本用法", Toast.LENGTH_LONG).show();
      }
  }
  ```
  
  

- Images 
  - save the images to res, drawable folder
  - activity_main.xml, search image, select ImageView, choose the images we want to show
  - layout the images 
  - be careful of scaleType
- onClick : the method called when a button is pressed 
- Currency converter