package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {

    SeekBar player_num_SB;
    Button next_BTN;
    TextView num_of_players_TV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find id's.
        player_num_SB = findViewById(R.id.player_num_seekbar);
        next_BTN = findViewById(R.id.next_btn_mainmenu);
        num_of_players_TV = findViewById(R.id.num_of_players_from_seekbar_tv);


        player_num_SB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 2;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                num_of_players_TV.setText(progressChangedValue);
            }
        });

        // Player 1 BTN counter click listener.
        next_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton(view);
            }
        });
    }

    public void nextButton(View view) {
        Intent intent = new Intent(this, PlayerInfo.class);

        intent.putExtra("number of players", "Player 1 Wins!");
        startActivity(intent);
    }


}
