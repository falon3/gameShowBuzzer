package com.example.scheers.gameshowbuzzer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by scheers on 10/3/15.
 */
public class ReactionTimerPlayActivity extends MainActivity {
    Button TimerIntroPrompt;
    Button StopButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_timer_play_screen);
        StopButton = (Button) findViewById(R.id.StopButton);
        addListenerOnButtonRed();
        delayUntilGreen();
    }

    public void delayUntilGreen() {
        // after a certain delay, change background color of button
        // source credit: http://stackoverflow.com/questions/15874117/how-to-set-delay-in-android
        // random b/w 10ms and 2000ms
        int rand_time = new Random().nextInt(2000 - 10) + 10;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                StopButton.setBackgroundColor(Color.GREEN);
                addListenerOnButtonGreen();

            }
        }, rand_time);
    }


    public void addListenerOnButtonRed() {
        StopButton = (Button) findViewById(R.id.StopButton);
        final Context context = this;
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // this makes a pop-up alert with a dismiss button.
                // source credit: http://stackoverflow.com/questions/2115758/how-to-display-alert-dialog-in-android
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setMessage("Pressed Too Early! \n Wait until button turns green to press!");
                alert.setCancelable(true);
                alert.setPositiveButton("retry",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                StopButton.setBackgroundColor(Color.RED);
                                delayUntilGreen();
                                addListenerOnButtonRed();
                                // restart timer here
                            }
                        });
                AlertDialog early_alert = alert.create();
                early_alert.show();
            }
        });
    }

    public void addListenerOnButtonGreen() {
        final long start_time = System.currentTimeMillis();
        StopButton = (Button) findViewById(R.id.StopButton);
        final Context context = this;
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                long total_time = System.currentTimeMillis() - start_time;
                AlertDialog.Builder result = new AlertDialog.Builder(context);
                result.setMessage("Time pressed: ");
                result.setCancelable(true);
                result.setPositiveButton("play again?",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                StopButton.setBackgroundColor(Color.RED);

                                //Intent intent = new Intent(ReactionTimerPlayActivity.this, ReactionTimerPlayActivity.class);
                                addListenerOnButtonRed();
                                delayUntilGreen();
                                // restart timer here
                            }
                        });
                AlertDialog early_alert = result.create();
                early_alert.show();
            }

        });

    }
}


