package com.example.burke.coms_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameScreen extends Activity {

    String player1_name;
    String player2_name;
    String player3_name;
    String player4_name;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.win_screen);

        //String[] textArray = {"One", "Two", "Three", "Four"};
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        /*for( int i = 0; i < textArray.length; i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(textArray[i]);
            linearLayout.addView(textView);
        }*/



        // Gets per player info (name & icon choice).
        Bundle extras = getIntent().getExtras();
        Intent intent = new Intent();

        String[] playerNames = extras.getStringArray("player names");
        int[] playersIconChoices = extras.getIntArray("player icon choice");
        //int numPlayers = intent.getStringExtra("");

        validatePlayerNames(playerNames);




        //for(int i = 0; i < LENGTH)
    }

    public void validatePlayerNames(String[] names) {
        if(names[0] != "0"){
            player1_name = names[0];
        }

        if(names[1] != "0"){
            player2_name = names[1];
        }

        if(names[2] != "0"){
            player3_name = names[2];
        }

        if(names[3] != "0"){
            player4_name = names[3];
        }
    }
}
