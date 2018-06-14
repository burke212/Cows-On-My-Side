package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.Cows-On-My-Side.extra.MESSAGE";

    Button p1_counter_BTN;
    Button p2_counter_BTN;
    Button finalizeBTN;
/*    TextView p1_counterTV;
    TextView p2_counterTV;*/

    int p1_counter = 0;
    int p2_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1_counter_BTN = findViewById(R.id.player1_counterBTN);
        p2_counter_BTN = findViewById(R.id.player2_counterBTN);
        finalizeBTN = findViewById(R.id.FinalizeBTN);
        /*p1_counterTV = findViewById(R.id.p1_counter1_num);
        p2_counterTV = findViewById(R.id.p2_counter1_num);*/


        p1_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer1BTN(view);
            }
        });

        p2_counter_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPlayer2BTN(view);
            }
        });

        finalizeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizeScore(view);
            }
        });
    }

    public void finalizeScore(View v) {
        Intent intent = new Intent(this, WinActivity.class);
        String tie = "Tie Game!";

        // Player 1 wins.
        if(p1_counter>p2_counter){
            intent.putExtra("player_wins", "Player 1 Wins!");
            intent.putExtra(EXTRA_MESSAGE, Integer.toString(p1_counter));
            startActivity(intent);
        }
        // Player 2 wins.
        else if(p2_counter>p1_counter){
            intent.putExtra("player_wins", "Player 2 Wins!");
            intent.putExtra(EXTRA_MESSAGE, Integer.toString(p2_counter));
            startActivity(intent);
        }
        // Tie game.
        else{
            intent.putExtra(EXTRA_MESSAGE, tie);
            startActivity(intent);
        }
    }

    public void clickPlayer2BTN(View v) {
        p2_counter++;
        p2_counter_BTN.setText(Integer.toString(p2_counter));
        //p2_counterTV.setText(Integer.toString(p2_counter));
    }

    public void clickPlayer1BTN(View v){
        p1_counter++;
        p1_counter_BTN.setText(Integer.toString(p1_counter));
        //p1_counterTV.setText(Integer.toString(p1_counter));
    }



}
