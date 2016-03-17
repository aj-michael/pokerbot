package edu.rosehulman.pokerbot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Data {
    String name;
    boolean your_turn;
    int initial_stack;
    int stack;
    int current_bet;
    int call_amount;
    String[] hand;
    String[] community_cards;
    String betting_phase;
    List<Player> players_at_table;
    int total_players_remaining;
    int table_id;
    int round_id;
    List<Map<String,Integer>> round_history;
    String lost_at;

    int position() {
        for (int i = 0; i < players_at_table.size(); i++) {
            if (players_at_table.get(i).player_name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "your_turn: " + your_turn + "\t" + "call_amount: " + call_amount + "\t" + "hand: " + Arrays.asList(hand);
    }
}
