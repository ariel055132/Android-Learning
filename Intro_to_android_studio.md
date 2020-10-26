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



Chapter 4

animations, sound, video

- Images, Video and Sound
  - make app to be more interactive and fun to use
  - grid layout
  
- Customizing App Layouts

  1. Constrained Layout
  2. Relative Layout
  3. Text Tab (use XML to describe the layout)
  4. Linear Layout

- Fading animations

  - Create app with image Bart Simpson and when the image is tapped we are going to morph him into homer Simpson

  - res -> drawable folder

  - image file name must contain lowercase or numbers (fuck!!!!!!)

  - ImageView -> Set the constraints -> search onclick -> name the function -> MainActivity.java -> defined the function 

    ```java
    // find the imageView by ID
    ImageView imageView = (ImageView) findViewById(R.id.imageView); // Bart Simpson
    ImageView imageView1 = (ImageView) findViewById(R.id.imageView1); // Homer Simpson
    // change the image 
    imageView.animate().alpha(0).setDuration(2000); // transparency, faded out completely after 2 seconds
    imageView.animate().alpha(1).setDuration(2000); 
```
    
    Small Task : click image, bart simpson -> Homer Simpson -> bart simpson
    
    add a boolean variable to control to show which image
  
- Other Animations

  Always remember to setDuration();

  1. translationX() : move
  2. translationXBy() : moves it in the x direction by a certain number of the piece
  3. rotation(degrees) : rotate by the degrees
  4. scale : scale to a specific value

- Connect 3 Game

  - grid layout  : to draw the board

    rowcount, columncount, Layout_margin, 

  - tags : keep track on which area is filled in counter

  - animation learned in the previous sections

- Video

  
