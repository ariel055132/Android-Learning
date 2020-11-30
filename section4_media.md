## Media: Images, Video and Sound

#### Customising App Layout

* activity_main.xml  -> left patlets -> Layout -> Choose the layout that you used to create the app

1. Constrained Layout (default in android 3)
   - use the constrain to decide the components that where they are going to display on the screen 
2. Relative Layout (default in android 2)
   - The components will be positioned according to the nearest margins
3. Text tab
   - use XML file to describe the layout
4. Linear Layout

#### Fading Animations

1. Create app with image Bart Simpson and when the image is tapped we are going to morph him into homer Simpson

2. image put into (res -> drawable folder)

3. image file name must contain lowercase or numbers

4. steps : ImageView -> Set the constraints -> search onclick -> name the function -> MainActivity.java -> defined the function 

5. Always remember to setDuration() 

   ```java
   package com.example.animation;
   import androidx.appcompat.app.AppCompatActivity;
   import android.media.Image;
   import android.os.Bundle;
   import android.util.Log;
   import android.view.View;
   import android.widget.ImageView;
   
   public class MainActivity extends AppCompatActivity {
       boolean first = true;
       public void fade(View view) {
           Log.i("Info", "ImageView tapped");
           // find the imageView by ID
           ImageView imageView = (ImageView) findViewById(R.id.imageView);
           ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
   
   		// change the image
           // animate : start doing animation
   		// alpha : transparency, 0 means invisible(faded out completely), 1 means visible
   		// setDuration: 2000 millieseconds --> 2 seconds
           // first == true, changed bart Simpson to Homer Simpson
           if (first) {
               imageView.animate().alpha(0).setDuration(2000);  
               imageView1.animate().alpha(1).setDuration(2000);
               first = false;
           }
           // first == false, changed Homer Simpson to Bart Simpson
           else {
               imageView.animate().alpha(1).setDuration(2000);
               imageView1.animate().alpha(0).setDuration(2000);
               first = true;
           }
       }
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
   
           ImageView imageView = (ImageView) findViewById(R.id.imageView);
           imageView.setX(-1000);
           imageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);
       }
   }
   ```



1. Another Animation

   * translationX : translates to a particular value (same as move) 移动到哪里

     ```java
     ImageView imageView = (ImageView) findViewById(R.id.imageView);
     // move to left for 1000 units (-1000)
     imageView.animate().translationX(-1000).setDuration(2000);
     ```

   * translationXBy : move it in the x direction by a certain number of the piece 沿x轴平行移动500个单位

     ```
     ImageView imageView = (ImageView) findViewById(R.id.imageView);
     // move to left for 1000 units (-1000)
     imageView.animate().translationXBy(-1000).setDuration(2000);
     ```

   * Difference of translation and translationBy

     * for translationY it represents an absolute position,
     * for translationYBy it represents on offset from the current value.
     * e.g : if you set translationYBy(100) it would move the current position from 360 to 460 and remane at position 460

   * Rotation(degrees) : rotates with the degrees

     ```java
     // rotate 30 degrees in 2 seconds
     imageView.animate().rotation(30).setDuration(2000);
     ```

   * Scale : scale to a specific value

     ```java
     // shrink the original image scale to half
     // convert to double to float with (float) or f
     imageView.animate().scaleX((float)0.5).scaleY((float)0.5).setDuration(2000);
     ```

   * ScaleBy : scale by a specific value

   * EX: animate image into existence, start the app with a blank screen, spin into action from the left, after the animation the image should be full screen just like it was at the beginning of the app.

     ```java
     package com.example.animation1;
     
     import androidx.appcompat.app.AppCompatActivity;
     
     import android.media.Image;
     import android.os.Bundle;
     import android.util.Log;
     import android.view.View;
     import android.widget.ImageView;
     
     // A small animation
     // Bart will rotate in a circle for 2 seconds
     // After click the image, it will decrease in scale 0.5.
     
     public class MainActivity extends AppCompatActivity {
     
         public void fade(View view) {
             Log.i("Info", "ImageView tapped");
             ImageView imageView = (ImageView) findViewById(R.id.imageView);
             //imageView.animate().scaleX((float)0.5).scaleY((float)0.5).setDuration(2000);
         }
         @Override
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             ImageView imageView = (ImageView) findViewById(R.id.imageView);
             imageView.setX(-1000);
             imageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);
         }
     }
     ```

#### Video

* Learn how to embed a video to the App

* put the video in **res/raw folder** (if raw folder was not found in android studio, create a directory in res folder)

* **VideoView** in main activity layout

  ```java
  package com.example.video;
  
  import androidx.appcompat.app.AppCompatActivity;
  import android.media.MediaPlayer;
  import android.net.Uri;
  import android.os.Bundle;
  import android.widget.MediaController;
  import android.widget.VideoView;
  
  public class MainActivity extends AppCompatActivity {
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          // find the VideoView by ID
          VideoView videoView = (VideoView) findViewById(R.id.videoView);
  		// set File Path of the video
          String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
          Uri uri = Uri.parse(uriPath);
          // setVideoPath() can also be used, however it can only be used if the video is stored on your device, so use setVideoURI is more appropriate
          videoView.setVideoURI(uri);
          
          // Add the controls (Play, Pause, Stop, etc) to the video, you will find these controls in the bottom of the video after adding these code
          MediaController mediaController = new MediaController(this);
          // Anchor the controller to the video
          mediaController.setAnchorView(videoView);
          // Allow the mediaController to control the videoView
          videoView.setMediaController(mediaController);
          // start play the video when the app is launched
          videoView.start();
      }
  }
  ```

  * Some errors pop up :  NO AMD Vulkan driver is found.
  * Solution : Create a new virtual machine, select Software - GLES 2.0 in the Emulated Performance while creating the AVD (https://stackoverflow.com/questions/58391908/android-studio-emulator-is-not-working-on-windows-7/58392200#comment103130350_58391908)



#### Audio





