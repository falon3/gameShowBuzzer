/*This file is part of scheers-reflex.

        scheers-reflex is a reaction timer and gameshow buzzer application for Android

        scheers-reflex is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        scheers-reflex is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with scheers-reflex. If not, see <http://www.gnu.org/licenses/>.*/

package com.example.scheers.gameshowbuzzer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        // after a certain delay, change background color of button to green
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

    // When button is Red I have the mode where it reacts with warning message if pressed
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

                                // restart reaction timer game by re-setting this Layout
                                StopButton.setBackgroundColor(Color.RED);
                                delayUntilGreen();
                                addListenerOnButtonRed();

                            }
                        });
                AlertDialog early_alert = alert.create();
                early_alert.show();
            }
        });
    }

    // When button is Green I have the mode where it times the reaction,
    // saves it to the stats file and displays it in pop-up
    public void addListenerOnButtonGreen() {
        final long start_time = System.currentTimeMillis();

        StopButton = (Button) findViewById(R.id.StopButton);
        final Context context = this;
        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // on click calculate time passed since turned green
                Long total_time = System.currentTimeMillis() - start_time;
                //update the arraylist stat
                stats.add_time_stats(total_time);

                AlertDialog.Builder result = new AlertDialog.Builder(context);
                Long d = stats.get_reaction_times(1);
                String result_to_print = String.format("%d", (Long) d);
                result.setMessage(result_to_print + " ms");

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


