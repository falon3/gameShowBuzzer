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
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by scheers on 10/4/15.
 */
public class Statistics extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_layout);
        //update_timer_stats(); DIDN'T WORK
    }

    private ArrayList<Long> reactions_times = new ArrayList<Long>();
    private ArrayList<Integer> buzzer_game_num_players = new ArrayList<Integer>();
    private ArrayList<String> buzzer_game_winner = new ArrayList<String>();


    public void add_time_stats(long reaction_time) {
        reactions_times.add(reaction_time);

    }
    public void add_player_stats(int num_players, String game_winner){
        buzzer_game_num_players.add(num_players);
        buzzer_game_winner.add(game_winner);
    }


    // functions to get the stats saved and access in order of most recently saved
    public Long get_reaction_times(int index_from_last) {
        int num_records = reactions_times.size();
        if (num_records == 0) {
            return null;
        } else {
            return reactions_times.get(num_records - index_from_last);
        }
    }

    public Integer get_num_players_in_multi_game(int index_from_last){
        int num_games = buzzer_game_num_players.size();
        if (num_games == 0) {
            return null;
        } else {
            return buzzer_game_num_players.get(num_games - index_from_last);
        }
    }

    public String get_multi_game_winners(int index_from_last){
        int num_games = buzzer_game_winner.size();
        if (num_games == 0) {
            return null;
        } else {
            return buzzer_game_winner.get(num_games - index_from_last);
        }
    }

    public void update_timer_stats()

    {
        //hmm tried a few things here but stats weren't accessible as I thought

        //Long d = Collections.max(reactions_times);
        Long d = get_reaction_times(1);
        String max_all_to_print = String.format("%d", (Long)d);
        //max_all_to_print = "Max time response:" + max_all_to_print;

        final TextView textViewToChange = (TextView) findViewById(R.id.textView4);
        textViewToChange.setText(max_all_to_print);
    }

    }



