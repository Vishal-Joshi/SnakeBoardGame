package com.springapp.mvc;

import com.springapp.mvc.controller.GameController;
import com.springapp.mvc.service.*;
import org.apache.tools.ant.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vishal Joshi on 19/2/15.
 */
public class AutoGamePlayer {

    public static void main(String[] args){
        PlayerService playerService = new PlayerServiceImpl();
        RollableDice rollableDice = new RandomRollableDice();
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(prepareSnakeBoard());
        GameController gameController = new GameController(playerService, rollableDice, snakeBoardService);
        while(playerService.getPlayer().getCurrentPosition() <= 100) {
            gameController.play();
        }
        System.out.println("Yipiee----You won!!-------------");
    }

    private static SnakeBoard prepareSnakeBoard(){
        Ladder ladderFrom4To14 = new Ladder(4,14);
        Ladder ladderFrom20To38 = new Ladder(20,38);
        Ladder ladderFrom9To31 = new Ladder(9,31);
        Ladder ladderFrom28To84 = new Ladder(28,84);
        Ladder ladderFrom40To59 = new Ladder(40,59);
        Ladder ladderFrom51To67 = new Ladder(51,67);
        Ladder ladderFrom63To81 = new Ladder(63,81);
        Ladder ladderFrom71To91 = new Ladder(71,91);
        List<Ladder> ladders = new ArrayList<Ladder>();
        Collections.addAll(ladders, ladderFrom4To14, ladderFrom20To38, ladderFrom9To31, ladderFrom28To84, ladderFrom40To59, ladderFrom51To67, ladderFrom63To81, ladderFrom71To91);


        Snake snakeFrom17To7 = new Snake(17,7);
        Snake snakeFrom62To19 = new Snake(62,19);
        Snake snakeFrom87To24 = new Snake(87,24);
        Snake snakeFrom64To60 = new Snake(64,60);
        Snake snakeFrom54To34 = new Snake(54,34);
        Snake snakeFrom99To78 = new Snake(99,78);
        Snake snakeFrom93To73 = new Snake(93,73);
        List<Snake> snakes = new ArrayList<Snake>();
        Collections.addAll(snakes, snakeFrom17To7, snakeFrom62To19, snakeFrom87To24, snakeFrom64To60, snakeFrom54To34, snakeFrom99To78, snakeFrom93To73);
        SnakeBoard snakeBoard = new SnakeBoard(snakes, ladders);
        return snakeBoard;
    }
}
