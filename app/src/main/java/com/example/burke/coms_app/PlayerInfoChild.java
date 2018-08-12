package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayerInfoChild extends Activity {

    TextView player_num_TV;
    EditText player_name_ET;
    ImageButton white_cow_IB;
    ImageButton brown_cow_IB;
    ImageButton purple_cow_IB;
    Button next_BTN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);

        // Get IDs
        player_num_TV = findViewById(R.id.player_info_tv);
        player_name_ET = findViewById(R.id.player_name_et);
        white_cow_IB = findViewById(R.id.player_icon_1_imageButton);
        brown_cow_IB = findViewById(R.id.player_icon_2_imageButton);
        purple_cow_IB = findViewById(R.id.player_icon_3_imageButton);
        next_BTN = findViewById(R.id.next_btn_player_info);


        Intent intentReceive = getIntent();
        String player_number = intentReceive.getStringExtra("player number");

        player_num_TV.setText("Player " + player_number);// Change the title text to "Player #".

        player_name_ET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSend = new Intent();
                String player_name = player_name_ET.getText().toString();// Get player name.
                int icon_choice = 0;

                if(white_cow_IB.isSelected()){
                    icon_choice = 0;// Choose white cow.
                }
                else if(brown_cow_IB.isSelected()){
                    icon_choice = 1;// Choose brown cow.
                }
                else{
                    icon_choice = 2;// Choose purple cow.
                }

                // Send the current player's name and icon choice.
                intentSend.putExtra("player name", player_name);
                intentSend.putExtra("icon choice", icon_choice);
                startActivity(intentSend);
            }
        });
    }
}
