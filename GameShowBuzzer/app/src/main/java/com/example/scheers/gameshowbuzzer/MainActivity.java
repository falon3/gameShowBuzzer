/*This file is part of GameShowBuzzer.

        gameShowBuzzer is a reaction timer and gameshow buzzer application for Android

        GameShowBuzzer is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        GameShowBuzzer is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with GameShowBuzzer. If not, see <http://www.gnu.org/licenses/>.*/

package com.example.scheers.gameshowbuzzer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button reactionTimerButton;
    Button gameShowBuzzerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;
        reactionTimerButton = (Button) findViewById(R.id.reactionTimerButton);
        reactionTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(context, ReactionTimerIntroActivity.class);
                startActivity(intent1);

            }

        });
        gameShowBuzzerButton = (Button) findViewById(R.id.gameShowBuzzerButton);
        gameShowBuzzerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent2 = new Intent(context, BuzzerGameActivity.class);
                startActivity(intent2);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void GoToReactionTimerGame(View view) {

    }
}
