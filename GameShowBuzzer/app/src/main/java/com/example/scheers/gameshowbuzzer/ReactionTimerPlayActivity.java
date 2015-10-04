package com.example.scheers.gameshowbuzzer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

/**
 * Created by scheers on 10/3/15.
 */
public class ReactionTimerPlayActivity extends MainActivity{
    Button TimerIntroPrompt;
    Button StopButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_timer_play_screen);
        addListenerOnButton3();
    }

    public void addListenerOnButton3() {

        final Context context = this;
        StopButton = (Button) findViewById(R.id.StopButton);
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent2 = new Intent(context, ReactionTimerResults.class);
                startActivity(intent2);

            }

        });
    }
}
