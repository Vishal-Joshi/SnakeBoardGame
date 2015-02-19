package com.springapp.mvc;

import java.util.List;

/**
 * Created by root on 19/2/15.
 */
public class SnakeBoard {

    private List<Snake> snakes;
    private List<Ladder> ladders;

    public SnakeBoard(List<Snake> snakes, List<Ladder> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
