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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by scheers on 10/4/15.
 */
public class HowManyPlayersActivity extends ActionBarActivity {
    Button twoPlayers;
    Button threePlayers;
    Button fourPlayers;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_many_players);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        twoPlayers = (Button) findViewById(R.id.twoPlayers);
        twoPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(context, BuzzerGameTwoActivity.class);
                startActivity(intent1);
            }

        });

        threePlayers = (Button) findViewById(R.id.threePlayers);
        threePlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent2 = new Intent(context, BuzzerGameThreeActivity.class);
                startActivity(intent2);
            }

        });

        fourPlayers = (Button) findViewById(R.id.fourPlayers);
        fourPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent3 = new Intent(context, BuzzerGameFourActivity.class);
                startActivity(intent3);
            }

        });
    }
}
