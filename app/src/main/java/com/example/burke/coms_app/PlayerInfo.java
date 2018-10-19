package com.example.burke.coms_app;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayerInfo extends Activity{

    TextView player_num_TV;
    EditText player_name_ET;
    ImageButton white_cow_IB;
    ImageButton brown_cow_IB;
    ImageButton purple_cow_IB;
    Button next_BTN;

    String players_names[] = {"0", "0", "0", "0"};
    int players_icon_choices[] = {0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);

        // Get IDs
        player_num_TV = findViewById(R.id.player_info_tv);
        player_name_ET = findViewById(R.id.player_name_et);
        white_cow_IB = findViewById(R.id.player_icon_1_imageButton);
        brown_cow_IB = findViewById(R.id.player_icon_2_imageButton);
        purple_cow_IB = findViewById(R.id.player_icon_3_imageButton);
        next_BTN = findViewById(R.id.next_btn_player_info);

        // Intent to get the number of players.
        Intent intent = getIntent();
        final String num_of_players_str = intent.getStringExtra("number_of_players");

        getPlayerInfo(num_of_players_str);

        // Player 1 BTN counter click listener.
        next_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    /*need to send all players names & chosen icons*//*
    public void nextButton(View view) {
        Intent intent = new Intent(this, PlayerInfo.class);

        intent.putExtra("number of players", "Player 1 Wins!");
        startActivity(intent);
    }*/

    public void getPlayerInfo(String num_of_players){

        // Get player's names & icons as many times as there are players
        for(int i = 1; i <= Integer.parseInt(num_of_players); i++){
            // Reset the TV so that the correct player number (i.e. player 1, 2... is displayed.
            player_num_TV.setText("Player " + Integer.toString(i));

            // Intent to send the player number (not num of players).
//            Intent intentSend = new Intent(this, MainActivity.class);

            // Intent to get per player info (name & icon choice).
//            Intent intentGet = getIntent();

            // Send the current player's number (1, 2, 3, 4).
//            intentSend.putExtra("player number", i);
//            startActivity(intentSend);

//            players_names[i] = intentGet.getStringExtra("player name");// Get player name.
//            players_icon_choices[i] = Integer.parseInt(intentGet.getStringExtra("icon choice"));// Get player icon choice.


        }
    }

    public void sentPlayerInfo(){
        Intent intent = new Intent(this, GameScreen.class);

        // Send players name array.
        intent.putExtra("player names", players_names);
        intent.putExtra("player icon choice", players_icon_choices);
        startActivity(intent);
    }
}
