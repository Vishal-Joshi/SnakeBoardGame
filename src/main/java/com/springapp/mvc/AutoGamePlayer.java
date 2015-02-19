package com.springapp.mvc;

import com.springapp.mvc.service.*;

/**
 * Created by Vishal Joshi on 19/2/15.
 */
public class AutoGamePlayer {

    public static void main(String[] args){
        PlayerService playerService = new PlayerServiceImpl();
        RollableDice rollableDice = new RandomRollableDice();
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(prepareSnakeBoard());
    }

    private static SnakeBoard prepareSnakeBoard(){
        Ladder ladder
        return null;
    }
}
