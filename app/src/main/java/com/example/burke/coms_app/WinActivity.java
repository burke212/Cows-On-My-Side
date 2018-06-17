package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends Activity {

    Button finalizeBTN;
    TextView winnerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_screen);

        finalizeBTN = findViewById(R.id.homeBTN);
        winnerTV = findViewById(R.id.final_score);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String winner = intent.getStringExtra("player_wins");
        String message = intent.getStringExtra("Player Counter");

        if(winner == null){
            winnerTV.setText(message);
        }
        else{
            message = winner + " " + message;

            winnerTV.setText(message);
        }

        finalizeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetScore(view);
            }
        });
    }

    public void resetScore(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
