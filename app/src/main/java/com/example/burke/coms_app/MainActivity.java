package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    TextView p1_TV;
    TextView p2_TV;
    TextView p3_TV;
    TextView p4_TV;
    TextView p5_TV;
    Button p1_counter_BTN;
    Button p2_counter_BTN;
    Button p3_counter_BTN;
    Button p4_counter_BTN;
    Button p5_counter_BTN;
    Button finalizeBTN;

    int p1_counter = 0;
    int p2_counter = 0;
    int p3_counter = 0;
    int p4_counter = 0;
    int p5_counter = 0;

    List<Integer> scores = new ArrayList<Integer>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find id's.
        p1_TV = findViewById(R.id.player1_tv);
        p2_TV = findViewById(R.id.player2_tv);
        p3_TV = findViewById(R.id.player3_tv);
        p4_TV = findViewById(R.id.player4_tv);
        p5_TV = findViewById(R.id.player5_tv);
        p1_counter_BTN = findViewById(R.id.player1_counter_btn);
        p2_counter_BTN = findViewById(R.id.player2_counter_btn);
        p3_counter_BTN = findViewById(R.id.player3_counter_btn);
        p4_counter_BTN = findViewById(R.id.player4_counter_btn);
        p5_counter_BTN = findViewById(R.id.player5_counter_btn);
        finalizeBTN = findViewById(R.id.final_score_btn);

        initializeScores();

        // Player 1 BTN counter click listener.
        p1_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer1BTN(view);
            }
        });

        // Player 2 BTN counter click listener.
        p2_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer2BTN(view);
            }
        });

        // Player 3 BTN counter click listener.
        p3_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer3BTN(view);
            }
        });

        // Player 4 BTN counter click listener.
        p4_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer4BTN(view);
            }
        });

        // Player 5 BTN counter click listener.
        p5_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer5BTN(view);
            }
        });

        // Score BTN counter click listener.
        finalizeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizeScore(view);
            }
        });
    }

    private void initializeScores() {
        for(int i = 1; i<=5;i++){
            scores.add(0);
        }
    }


    // Increase button counter, & display new value.
    public void clickPlayer1BTN(View v){
        p1_counter++;
        scores.set(0, p1_counter);
        p1_counter_BTN.setText(String.format(String.valueOf(p1_counter)));
    }

    // Increase button counter, & display new value.
    public void clickPlayer2BTN(View v) {
        p2_counter++;
        scores.set(1, p2_counter);
        p2_counter_BTN.setText(String.format(String.valueOf(p2_counter)));
        /*p2_counter_BTN.setText(Integer.toString(p2_counter));*/
    }

    // Increase button counter, & display new value.
    private void clickPlayer3BTN(View view) {
        p3_counter++;
        scores.set(2, p3_counter);
        p3_counter_BTN.setText(String.format(String.valueOf(p3_counter)));
    }

    // Increase button counter, & display new value.
    private void clickPlayer4BTN(View view) {
        p4_counter++;
        scores.set(3, p4_counter);
        p4_counter_BTN.setText(String.format(String.valueOf(p4_counter)));
    }

    // Increase button counter, & display new value.
    private void clickPlayer5BTN(View view) {
        p5_counter++;
        scores.set(4, p5_counter);
        p5_counter_BTN.setText(String.format(String.valueOf(p5_counter)));
    }

    // Finalize scores. Initiate new activity.
    public void finalizeScore(View v) {
        Intent intent = new Intent(this, WinActivity.class);
        String tie = "Tie Game!";

        int player_with_highest_score = getHighestScore();

        switch (player_with_highest_score){
            case 0:// Player 1 wins
                intent.putExtra("player_wins", "Player 1 Wins!");
                intent.putExtra("Player Counter", Integer.toString(p1_counter));
                startActivity(intent);
                break;
            case 1:// Player 2 wins
                intent.putExtra("player_wins", "Player 2 Wins!");
                intent.putExtra("Player Counter", Integer.toString(p2_counter));
                startActivity(intent);
                break;
            case 2:// Player 3 wins
                intent.putExtra("player_wins", "Player 3 Wins!");
                intent.putExtra("Player Counter", Integer.toString(p3_counter));
                startActivity(intent);
                break;
            case 3:// Player 4 wins
                intent.putExtra("player_wins", "Player 4 Wins!");
                intent.putExtra("Player Counter", Integer.toString(p4_counter));
                startActivity(intent);
                break;
            case 4:// Player 5 wins
                intent.putExtra("player_wins", "Player 5 Wins!");
                intent.putExtra("Player Counter", Integer.toString(p5_counter));
                startActivity(intent);
                break;
            default:// Tie game
                intent.putExtra("Player Counter", tie);
                startActivity(intent);
                break;
        }

/*        // Player 1 wins.
        if(p1_counter>p2_counter){
            intent.putExtra("player_wins", "Player 1 Wins!");
            intent.putExtra("Player Counter", Integer.toString(p1_counter));
            startActivity(intent);
        }
        // Player 2 wins.
        else if(p2_counter>p1_counter){
            intent.putExtra("player_wins", "Player 2 Wins!");
            intent.putExtra("Player Counter", Integer.toString(p2_counter));
            startActivity(intent);
        }
        // Tie game.
        else{
            intent.putExtra("Player Counter", tie);
            startActivity(intent);
        }*/
    }

    private int getHighestScore() {
        /*
        * need to search the list/ arraylist so that the highest value's index is returne. i.e. the
        * largest value will return its index, which will tell you which player has the highest score.
        *
        * Checkout: https://stackoverflow.com/questions/12788182/finding-the-largest-value-in-an-arraylist*/

        int counter = 0;
        int max = 0;
        int index = 0;

        for(int elem : scores){
            if(max<elem){
                max = elem;
                index = counter;
            }
            counter++;
        }

        /*
        * int counter =0;
        * int maxNum = 0;
        * int index =0;
        * for(int num : arrayListOfNumbers){
        *   if(maxNum<num){
        *       maxNum = num;
        *       index= counter;
        *   }
        *counter++;
        * }
        * System.Out.printLn(“The biggest number is ”+ maxNum + “ and its index in array list is “ + index);
        *
        * */
        return index;
    }

}
