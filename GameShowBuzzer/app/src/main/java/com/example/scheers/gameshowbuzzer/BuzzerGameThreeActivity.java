package com.example.scheers.gameshowbuzzer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
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
        player1Button = (Button) findViewById(R.id.player1Button);
        player2Button = (Button) findViewById(R.id.player2Button);
        player3Button = (Button) findViewById(R.id.player3Button);
        addListenerOnButtons();

    }

    public void addListenerOnButtons() {
        final Context context = this;
        player1Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // this makes a pop-up alert with a dismiss button.
                // source credit: http://stackoverflow.com/questions/2115758/how-to-display-alert-dialog-in-android
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setMessage("Player One!");
                alert.setCancelable(true);
                alert.setPositiveButton("dismiss",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                stats.add_player_stats(2, "Player One");

                            }
                        });
                AlertDialog p1_win = alert.create();
                p1_win.show();
            }
        });

        player2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setMessage("Player Two!");
                alert.setCancelable(true);
                alert.setPositiveButton("dismiss",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                stats.add_player_stats(2, "Player Two");

                            }
                        });
                AlertDialog p2_win = alert.create();
                p2_win.show();
            }
        });

        player3Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setMessage("Player Three!");
                alert.setCancelable(true);
                alert.setPositiveButton("dismiss",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                stats.add_player_stats(2, "Player Three");

                            }
                        });
                AlertDialog p3_win = alert.create();
                p3_win.show();
            }
        });
    }
}





