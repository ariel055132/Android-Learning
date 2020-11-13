## Introduction to Android Studio
#### Android Studio Overview
* manifests\AndroidManifest.xml
  - Contains the information about your app
* java\com.example.exampleApp\MainActivity
  - code for our app, main activity in our app
* res folder
  - resources for our app, where we keep things like images
* res\layout\activity_main.xml
  - visual representation of the app
* When Device freeze, click AVD Manager, choose the device, wipe out the data 

#### Formatting Text
* TextView 
  * Display text in the app
  * Fundamental user interface / UI element of view
  * Always add constraint / margins to textView in order to plan how it should be fixed on the screen
  * 顯示給使用者看的文字，使用者不得修改，只有開發者才行
* Edit under activity_main.xml (list useful attributes only)
	* 文字設定：android:text="要顯示在畫面上的文字"
  * 設定ID：android:id="@+id/此物件的ID"
* 設定寬：android:layout_width="寬度dp"
	* 設定高：android:layout_height="高度dp" ※寬度、高度的單位是用DP也稱DIP (Density- Independent Pixels)
	* 文字大小：android:textSize = "輸入文字大小sp" ※文字大小使用單位是SP也稱SIP(Scale Independent Pixels)
	* 背景顏色：android:background="#色碼"
	* 文字顏色：android:textColor="@color/顏色"  ※需要到value/colors.xml 中先設定
	* 文字粗體：android:textStyle="bold"
	* 文字斜體：android:textStyle="italic"
	* 文字換行：Hello \n World  ※換行的部分要在 value/strings.xml 設定
	* 文字置中：android:gravity="center_horizontal"
	* 文字靠右：android:gravity="right"
	* 文字靠左：android:gravity="left"
	
* Attributes on the right bar
  * Constraints : set up the position you want to put the string
  * layout_width, layout_height : match_constraint
  * text : string you want to show
  * font family, text Size, line Spacing, text colors, text Style, text alignment
  * visibility : the text appeared / disappeared ?
  * padding
  * alpha :  the transparency of the string
  * gravity : how the content of the text view floats around its container
  * background : 背景, can be image / color
* EX : Migrate app in green and bold and pretty large font and with an orange background

#### Button
* set up constraints of button first in order to fixed its position

* onClick : things will do when button is clicked, need to create the click function method in JAVA (MainActivity.java) 新增反應點擊事件的 Method

* 按鈕所觸發的事件處理，稱之為Event Handler，只不過在android的世界裡，按鈕事件是由系統的Button.onClickListener所控制。

* remember and setup the id of the button 

* 按鈕要加在 `activity_main.xml` 這個檔案中

* wrap_content : 「包覆內容」，意思就是「根據內容」決定該參數的值會是多少。  Android UI 元件的必填屬性

* 在按鈕裡面要設定文字內容，使用android:text屬性，但是系統會叫你在string resource裏面設定

  * 直接開啟 `app/res/values/strings.xml` 在裡面新增字串設定
  * 使用 Android Studio 的自動抽離功能 (automatically extract) ，把指定字串加入第一點提到的 `strings.xml` 這個檔案裡

  ```java
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
  ```

* EX : Create an interactivity demo that create the log you like when the button is pressed

  ```java
  package com.example.exampleapp;
  import androidx.appcompat.app.AppCompatActivity;
  import android.os.Bundle; 
  import android.util.Log;
  import android.view.View;
  
  public class MainActivity extends AppCompatActivity {
      public void clickFunction(View view) {
          Log.i("Info", "It worked!!!!!!!");
      }
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
  }
  ```

#### Text Fields

* Learn about text field and see how we can get the data within the text field

* Text Fields主要是一些動態的和用戶交互的內容，也即EditText，一般都需要輸入。像Plain Text，Person Name，Password，E-mail，Phone，Postal Address， Multiline Text，Time，Date，Number等。

* Select Plain Text element in activity_main.xml 

* hint : reminds user what types of information should he/she put 

  ```java
  package com.example.interactivitydemo;
  
  import androidx.appcompat.app.AppCompatActivity;
  
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View;
  import android.widget.EditText;
  
  public class MainActivity extends AppCompatActivity {
      public void clickFunction(View view) {
          // get the value of the name input by user
          EditText nameEditText = (EditText)findViewById(R.id.nameEditText);
          // display it into the logs
          // finds the texts, get the text, convert to string for output
          Log.i("Values", nameEditText.getText().toString());
      }
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
  }
  ```

* EX : create a login page that need the username and password enter, after press the button should say log in.

  ```java
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
  ```

  
#### Display messages
* We use *Toast*  to display messages at the bottom of the app (default).

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

  - How to embed a video to the App

  - androiddevcourse.com/demovideo.mp4  -> demo video

  - new Folder in res folder (called raw)

  - main activity layout --> videoView

    ```java
    public class MainActivity extends AppCompatActivity {
    	@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState); // use the method from parents
            setContentView(R.layout.activity_main);
            VideoView videoView = (VideoView) findViewById(R.id.videoView);
            // demovideo filepath
            videoView.setVideoPath("android.resourse//" + getPackageName() + "/" + R.raw.demovideo);
            // start playing the video
            videoView.start();
        }
        // colon is missing after resource
        // resource is mistyped to resourse
    }
```

    However, the emulator show that the video cannot be played.
    
    Correct the wrong file path and run again.
    
    ```java
    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            VideoView videoView = (VideoView) findViewById(R.id.videoView);
    		
    		// resourse --> resource:
            // Most of the solutions in StackOverFlow tend to use uriPath to save the file path before putting it into setVideoURI
            // setVideoPath can only be used if the video is stored on your device, use setVideoURI is more appropriate
            String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
            Uri uri = Uri.parse(uriPath);
            videoView.setVideoURI(uri);
            videoView.start();
        }
    }
    ```
    
    Then, the emulator show that NO AMD Vulkan driver is found.
    
    Create a new virtual machine, select Software - GLES 2.0 in the Emulated Performance while creating the AVD (https://stackoverflow.com/questions/58391908/android-studio-emulator-is-not-working-on-windows-7/58392200#comment103130350_58391908)
    
    Finally, the video can played smoothly.
    
    Although the video can be played smoothly, we noticed that where were no controls on that video. Therefore, add some controls (Play, Pause, Stop, etc)
    
    Media Controller is added.
    
    ```java
    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            VideoView videoView = (VideoView) findViewById(R.id.videoView);
            String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
            Uri uri = Uri.parse(uriPath);
            videoView.setVideoURI(uri);
            
            // this means in this app
            MediaController mediaController = new MediaController(this);
            // Anchor the controller to the video
            mediaController.setAnchorView(videoView);
            // Allow the mediaController to control the videoView
            videoView.setMediaController(mediaController);
    
            videoView.start();
        }
    }
    ```
    
    You will find the controller under the video. You can control the video now

- Audio

  - Create raw folder in res folder

  - no actual component to the audio player by default (no AudioView)

    ```java
    public class MainActivity extends AppCompatActivity {
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // setting up a MediaPlayer
            // create (where to be put, file path)
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bicycle_bell_ring);
            // Play
            mediaPlayer.start();
        }
    }
    ```

    Create our own system to control the audio (no MediaController in audio)

    Add two buttons to the app (Play and pause)

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

- Audio -- Volume and Seeking

  - use sliders to seek backwards and forwards through the audio and to change the volume

  - seekbar : a slide up (use it to control the volume)

  - SeekBar是ProgressBar的扩展，它比进度条多了一个可以拖动的功能，这样用户可以控制进度条，比如播放电影，音乐，图片缩放的时候可以控制图片预览，
  
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
    		
            // SeekBar implementation
            SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeSeekBar);
            volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    
                // Sth changed on the seek bar
                // int progress : the value of the seekbar
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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

  - Audio Controller : control the volume through the seek bar
  
    ```java
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
                    Log.i("Seekbar changed", Integer.toString(progress));
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
        }
  }
    ```

  - setMax(int max) : 设置最大值
  
  - setMin(int min) : 设置最小值
  
  - setProgress(int progress) : 设置seekbar当前的默认值，范围0到max之间
  
  - setThumb(Drawable thumb) : 显示的那个可拖动图标，如果没有设置该参数则为系统默认,如果自己需要重新定义，则将自己需要的图标存放在资源目录 /res/drawable下，然后调用即可。
  
  - setThumbOffset(int thumbOffset) : 拖动图标的偏量值,可以让拖动图标超过bar的长度
  
  - 		setProgressDrawable(Drawable d) : 自定义进度条背景


- Grid Layouts

  - Gravity
  
    

