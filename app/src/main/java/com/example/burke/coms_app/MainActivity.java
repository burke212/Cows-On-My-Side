package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView num_of_players_TV;
    Button two_player_BTN;
    Button three_player_BTN;
    Button four_player_BTN;
    Button five_player_BTN;

    int num_players = 0;
    int player_num = 0;
    String players_names[] = {"0", "0", "0", "0"};
    int players_icon_choices[] = {0, 0, 0, 0};
    
    Intent sendIntentPlayerInfo = new Intent(this, PlayerInfo.class);
    Intent receiveIntentPlayerInfo = new Intent(this, PlayerInfo.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        // Find id's.
        num_of_players_TV = findViewById(R.id.num_players_tv);
        two_player_BTN = findViewById(R.id.two_player_btn_mainmenu);
        three_player_BTN = findViewById(R.id.three_player_btn_mainmenu);
        four_player_BTN = findViewById(R.id.four_player_btn_mainmenu);
        five_player_BTN = findViewById(R.id.five_player_btn_mainmenu);


        two_player_BTN.setOnClickListener(this);
        three_player_BTN.setOnClickListener(this);
        four_player_BTN.setOnClickListener(this);
        five_player_BTN.setOnClickListener(this);
    }

    //@Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.two_player_btn_mainmenu:
                num_players = 2;
                getPlayerInfo(num_players);
                break;

            case R.id.three_player_btn_mainmenu:
                num_players = 3;
                getPlayerInfo(num_players);
                break;

            case R.id.four_player_btn_mainmenu:
                num_players = 4;
                getPlayerInfo(num_players);
                break;

            case R.id.five_player_btn_mainmenu:
                num_players = 5;
                getPlayerInfo(num_players);
                break;

            default:
                break;
        }
    }

    public void getPlayerInfo(int num_players){
        for(int i = 0; i < num_players; i++)
        {
            player_num = i;

            sendIntentPlayerInfo.putExtra("player number", player_num);
            sendIntentPlayerInfo.putExtra("number_of_players", num_players);
            
            startActivity(sendIntentPlayerInfo);
        }

    }

}
