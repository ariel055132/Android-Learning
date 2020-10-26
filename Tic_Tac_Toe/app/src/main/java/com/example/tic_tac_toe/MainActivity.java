package com.example.tic_tac_toe;
// aka Connect 3 stated in the video

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.FontRequest;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout; // Prevent error  androidx.gridlayout.widget.GridLayout cannot be cast to android.widget.GridLayout
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// Further Improvement
// 1. When the block has red / yellow image, it cannot be replaced by another image
// 2. The game should stop after someone wins
// 3. Start a new game

public class MainActivity extends AppCompatActivity {
    // Determine red / yellow is put into the board
    // true --> yellow , false --> red
    boolean active = true; // num can also be used, it is more flexible

    // Use array to save the filled area with red / yellow
    // 2 : empty, 1 : red, 0 : yellow
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    // winning positions (2-D array)
    // first 3 --> row / horizontal
    // 4-6 --> column / vertical
    // 7-8 --> diagonal
    int[][] winningPositions = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6} };

    // Use in Toast, to show who wins the game
    String winner = "";

    // when someone is Won --> false
    boolean gameActive = true;

    // Click the button
    public void dropin(View view) {
        ImageView cnt = (ImageView) view; // determine which block is click
        Log.i( "Tag", cnt.getTag().toString());
        int gameStateIndex = Integer.parseInt(cnt.getTag().toString());

        // Further Improvement
        // Image only can be input when the area is empty and the game is not over
        if (gameState[gameStateIndex] == 2 && gameActive == true) {
            if (active == true) {
                cnt.setImageResource(R.drawable.yellow);
                gameState[gameStateIndex] = 0;
                active = false;
            } else if (active == false) {
                cnt.setImageResource(R.drawable.red);
                gameState[gameStateIndex] = 1;
                active = true;
            }
            cnt.setTranslationY(-1500);
            cnt.animate().translationYBy(1500).rotation(3600).setDuration(300);

            // Check whether winning happens
            // use for loops to traversal the arrays
            for (int[] winningPosition : winningPositions) {
                // 0 == 1 && 1 == 2 --> 0 == 2 , and the area is not empty
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow";
                        gameActive = false;
                    } else {
                        winner = "Red";
                        gameActive = false;
                    }
                    // Toast.makeText(this, "Someone was won", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
                    Button playAgain = (Button) findViewById(R.id.newGame);
                    playAgain.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void playAgain(View view) {
        Button playAgain = (Button) findViewById(R.id.newGame);
        playAgain.setVisibility(View.INVISIBLE);

        // android loop through all objects in layout
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        for (int i = 0; i <= gridLayout.getChildCount(); i++) {
            ImageView child = (ImageView) gridLayout.getChildAt(i);
            // android remove imageview source
            child.setImageBitmap(null);
            //child.setImageDrawable(null);
            child.destroyDrawingCache();
        }
        active = true;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        //gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}