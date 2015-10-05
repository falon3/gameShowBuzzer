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
import android.os.Handler;
import android.view.View;
import android.widget.Button;

/**
 * Created by scheers on 10/3/15.
 */
public class ReactionTimerIntroActivity extends MainActivity {
    Button reactionTimerButton;
    Button TimerIntroPrompt;


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