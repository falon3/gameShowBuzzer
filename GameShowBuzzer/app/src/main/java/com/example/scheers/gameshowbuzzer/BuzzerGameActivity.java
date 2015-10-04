package com.example.scheers.gameshowbuzzer;

import android.os.Bundle;
import android.widget.Button;

/**
 * Created by scheers on 10/3/15.
 */
public class BuzzerGameActivity extends MainActivity{
    Button gameShowBuzzerButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buzzer_game);
    }


}
