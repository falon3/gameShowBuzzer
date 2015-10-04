package com.example.scheers.gameshowbuzzer;

import android.os.Bundle;
import android.widget.Button;

/**
 * Created by scheers on 10/3/15.
 */
public class ReactionTimerPlayActivity extends MainActivity{
    Button TimerIntroPrompt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_timer_play_screen);
    }
}
