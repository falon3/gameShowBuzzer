package com.example.scheers.gameshowbuzzer;

import java.util.ArrayList;

/**
 * Created by scheers on 10/4/15.
 */
public class Statistics {
    private ArrayList<Integer> single_play_reactions;
    private ArrayList<Integer> buzzer_game_num_players;
    private ArrayList<Integer> buzzer_game_winner;
    private ArrayList<Integer> buzzer_game_winner_times;

    public void add_single_stats(int reaction_time) {
        single_play_reactions.add(reaction_time);

    }
    public void add_multiplayer_stats(int num_players, int game_winner, int winner_time){
        buzzer_game_num_players.add(num_players);
        buzzer_game_winner.add(game_winner);
        buzzer_game_winner_times.add(winner_time);
    }

}
