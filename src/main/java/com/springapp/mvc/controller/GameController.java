package com.springapp.mvc.controller;

import com.springapp.mvc.Ladder;
import com.springapp.mvc.Player;
import com.springapp.mvc.service.PlayerService;
import com.springapp.mvc.service.RollableDice;
import com.springapp.mvc.service.SnakeBoardService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by root on 19/2/15.
 */
public class GameController {

    private PlayerService playerService;
    private RollableDice rollableDice;
    private SnakeBoardService snakeBoardService;

    @Autowired
    public GameController(PlayerService playerService, RollableDice rollableDice, SnakeBoardService snakeBoardService){
        this.playerService = playerService;
        this.rollableDice = rollableDice;
        this.snakeBoardService = snakeBoardService;
    }

    public void play(){
        Player player = playerService.getPlayer();
        int numberOfSteps = rollableDice.rollDice();
        player.move(numberOfSteps);
        if(snakeBoardService.isLadder(player.getCurrentPosition())){
            Ladder ladder = snakeBoardService.getLadder(player.getCurrentPosition());
            player.move(ladder.getEndStep()-ladder.getStartStep());
        }
    }
}
