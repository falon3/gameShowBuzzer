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
public class ReactionTimerIntroActivity extends MainActivity {
    Button reactionTimerButton;
    Button TimerIntroPrompt;
    Button StopButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_timer_intro);
        addListenerOnButton2();
    }

    public void addListenerOnButton2() {

        final Context context = this;
        TimerIntroPrompt = (Button) findViewById(R.id.TimerIntroPrompt);
        TimerIntroPrompt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(context, ReactionTimerPlayActivity.class);

                startActivity(intent1);

            }

        });
    }
}