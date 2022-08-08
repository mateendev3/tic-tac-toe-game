package com.mateenmehmood.mytictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView statusBar;

    //Active player 0 --> O, 1 --> X
    int activePlayer = 0;

    //1D array for gameState
    int[] gameState = new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    //2D array for all possible winning positions
    int[][] winningPositions = new int[][] {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusBar = findViewById(R.id.statusBar);
    }


    @SuppressLint("ResourceAsColor")
    public void tapPlayer(View view) {

        //getting that button that has been tapped
        Button btn = (Button) view;

        //getting tag of got btn
        int tappedButton = Integer.parseInt(btn.getTag().toString());

        if (gameState[tappedButton] == -1) {
            gameState[tappedButton] = activePlayer;

            if (activePlayer == 0) {
                btn.setTextColor(R.color.yellow);
                btn.setText(R.string.o_value);

                statusBar.setTextColor(R.color.green);
                statusBar.setText(R.string.player_X_turn);
                activePlayer = 1;
            } else {
                btn.setTextColor(R.color.green);
                btn.setText(R.string.x_value);

                statusBar.setTextColor(R.color.yellow);
                statusBar.setText(R.string.player_O_turn);
                activePlayer = 0;
            }
        }

    }
}