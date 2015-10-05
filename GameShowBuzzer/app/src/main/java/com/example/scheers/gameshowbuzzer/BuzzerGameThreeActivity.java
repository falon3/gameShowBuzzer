package com.example.scheers.gameshowbuzzer;

import android.os.Bundle;
import android.widget.Button;

/**
 * Created by scheers on 10/4/15.
 */
public class BuzzerGameThreeActivity extends MainActivity{

    Button player1Button;
    Button player2Button;
    Button player3Button;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buzzer_game_three);
    }
}

