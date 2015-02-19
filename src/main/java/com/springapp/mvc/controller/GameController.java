package com.springapp.mvc.controller;

import com.springapp.mvc.Player;
import com.springapp.mvc.service.PlayerService;
import com.springapp.mvc.service.RollableDice;
import com.springapp.mvc.service.SnakeBoardService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vishal Joshi on 19/2/15.
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
        System.out.println("Dice rolled to: "+numberOfSteps);
        int playersPositionAfterWalkingDice = player.getCurrentPosition() + numberOfSteps;
        System.out.println("Players position after walking dice: "+playersPositionAfterWalkingDice);
        int destinationStep = snakeBoardService.getDestinationStep(playersPositionAfterWalkingDice);
        player.moveTo(destinationStep);
        System.out.println("--final position of player is "+player.getCurrentPosition());

    }
}
