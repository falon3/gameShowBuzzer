package com.example.scheers.gameshowbuzzer;

import android.os.Bundle;
import android.widget.Button;

/**
 * Created by scheers on 10/3/15.
 */
public class BuzzerGameFourActivity extends MainActivity{
    Button player1Button;
    Button player2Button;
    Button player3Button;
    Button player4Button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buzzer_game_four);
    }


}
