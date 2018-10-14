package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity implements View.OnClickListener {

    TextView num_of_players_TV;
    Button two_player_BTN;
    Button three_player_BTN;
    Button four_player_BTN;
    Button five_player_BTN;

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


        two_player_BTN.setOnClickListener((View.OnClickListener) this);
        three_player_BTN.setOnClickListener((View.OnClickListener) this);
        four_player_BTN.setOnClickListener(this);
        five_player_BTN.setOnClickListener(this);
    }

    //@Override
    public void onClick(View view){
        Intent intent = new Intent(this, PlayerInfo.class);

        switch (view.getId()){
            case R.id.two_player_btn_mainmenu:
                intent.putExtra("number_of_players", 2);
                startActivity(intent);
                break;

            case R.id.three_player_btn_mainmenu:
                intent.putExtra("number_of_players", 3);
                startActivity(intent);
                break;

            case R.id.four_player_btn_mainmenu:
                intent.putExtra("number_of_players", 4);
                startActivity(intent);
                break;

            case R.id.five_player_btn_mainmenu:
                intent.putExtra("number_of_players", 5);
                startActivity(intent);
                break;

            default:
                break;
        }
    }


}
