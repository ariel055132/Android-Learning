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

* put the audio file in **res/raw folder** , same as video file(if raw folder was not found in android studio, create a directory in res folder)

* no actual component to the audio player by default (no AudioView), create **MediaPlayer** instead

* The first audio example

  ```java
  public class MainActivity extends AppCompatActivity {
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          // setting up a MediaPlayer, with audio file path
          MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bicycle_bell_ring);
          // Play the audio file
          mediaPlayer.start();
      }
  }
  ```

* Add some control to have interaction with the audio file (need to create by ourself, no MediaController in audio)

* Add two buttons to the app, which represents play and pause

  ```java
  public class MainActivity extends AppCompatActivity {
      MediaPlayer mediaPlayer;
      // Control system for the audio
      public void play(View view) {
          mediaPlayer.start();
      }
      public void pause(View view) {
          mediaPlayer.pause();
      }
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          // Prevent bug
          // When the user press pause but there is nothing to be played, the app will crash
          // Default there is some audio running in the app
          mediaPlayer = MediaPlayer.create(this, R.raw.bicycle_bell_ring);
      }
  }
  ```

#### Audio -- Volume Control and Seeking bar

* Sliders : to seek backwards and forwards through the audio and to change the volume

* use **seekbar** (activity_main.xml -> widget -> search seekbar), which is a slide up 

* SeekBar是ProgressBar的扩展，它比进度条多了一个可以拖动的功能，这样用户可以控制进度条，比如播放电影，音乐，图片缩放的时候可以控制图片预览

  ```java
  public class MainActivity extends AppCompatActivity {
      MediaPlayer mediaPlayer;
      // Control system for the audio
      public void play(View view) {
          mediaPlayer.start();
      }
      public void pause(View view) {
          mediaPlayer.pause();
      }
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          // Prevent bug
          // When the user press pause but there is nothing to be played, the app will crash
          // Default there is some audio running in the app
          mediaPlayer = MediaPlayer.create(this, R.raw.bicycle_bell_ring);
  		
          // SeekBar implementation, find the seekbar with the id
          SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeSeekBar);
          // the seekbar listens to the change in the seekbar and waits until the user moves the bar 
          volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              // User move the seekbar
              // int progress : the value of the seekbar
              @Override
              public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                  // watch whether the method is called when user moves the bar
                  Log.i("Seekbar changed", Integer.toString(progress));
              }
              // Users start touching the seek bar
              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {
              }
              // Users stop touching the seek bar
              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {
              }
          });
      }
  }
  ```

* use **AudioManager** to control the volume through the seek bar

  * Some properties of the audio Manager
  * setMax(int max) : 设置最大值
  * setMin(int min) : 设置最小值
* setProgress(int progress) : 设置seekbar当前的默认值，范围0到max之间
  * setThumb(Drawable thumb) : 显示的那个可拖动图标，如果没有设置该参数则为系统默认,如果自己需要重新定义，则将自己需要的图标存放在资源目录 /res/drawable下，然后调用即可。
* setThumbOffset(int thumbOffset) : 拖动图标的偏量值,可以让拖动图标超过bar的长度
  * setProgressDrawable(Drawable d) : 自定义进度条背景

  ```java
package com.example.sounddemo;
  import androidx.appcompat.app.AppCompatActivity;
  import android.media.AudioManager;
  import android.media.MediaPlayer;
  import android.os.Bundle;
  import android.provider.MediaStore;
  import android.util.Log;
  import android.view.View;
  import android.widget.SeekBar;
  import java.util.Timer;
  import java.util.TimerTask;
  
  // 1. Play, Pause button
  // 2. Volume control
  // 3. Sound effect time control
  public class MainActivity extends AppCompatActivity {
  
      MediaPlayer mediaPlayer;
      AudioManager audioManager;
  
      // Control system for the audio
      public void play(View view) {
          mediaPlayer.start();
      }
  
      public void pause(View view) {
          mediaPlayer.pause();
      }
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
  
          // Use the system service to fulfill audio request
          audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
  
          // get the maximum volume of the device, it may not be 100
          int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
          // get the current volume
          int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
  
          // When the user press pause but there is nothing to be played, the app will crash (Bug)
          // Default there is some audio running in the app
          mediaPlayer = MediaPlayer.create(this, R.raw.bicycle_bell_ring);
  
          //int minVolume = audioManager.getStreamMinVolume(AudioManager.STREAM_MUSIC);
          SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeSeekBar);
          volumeControl.setMax(maxVolume);
          // Set the current volume
          volumeControl.setProgress(currentVolume);
  
          volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              // Sth changed on the seek bar
              // int progress : the value of the seekbar
              @Override
              public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                  Log.i("Volume Seekbar changed", Integer.toString(progress));
                  audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
              }
              // Users start touching the seek bar
              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {
              }
              // Users stop touching the seek bar
              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {
              }
          });
          // Scrub Seekbar
          SeekBar scrubControl = (SeekBar) findViewById(R.id.scrubSeekBar);
          // we can scrub to the end of the song but not other
          scrubControl.setMax(mediaPlayer.getDuration());
  
          scrubControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              @Override
              public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                  Log.i("Scrub Seekbar changed", Integer.toString(progress));
                  mediaPlayer.seekTo(progress);
              }
  
              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {
                  mediaPlayer.start();
              }
  
              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {
                  mediaPlayer.pause();
              }
          });
  
          // Allow us to do something every second every minute every hour while our app is running
          new Timer().scheduleAtFixedRate(new TimerTask() {
              @Override
              public void run() {
                  scrubControl.setProgress(mediaPlayer.getCurrentPosition());
              }
          },0, 300);
      }
  }
  ```
  
  


