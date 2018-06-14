package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends Activity {

    Button finalizeBTN;
    TextView winnerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_screen);

        finalizeBTN = findViewById(R.id.resetBTN);
        winnerTV = findViewById(R.id.final_score);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        winnerTV.setText(message);
        //Log.d(message);
    }
}
