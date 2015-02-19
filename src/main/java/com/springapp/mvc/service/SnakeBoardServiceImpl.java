package com.springapp.mvc.service;

import com.springapp.mvc.Ladder;
import com.springapp.mvc.Snake;
import com.springapp.mvc.SnakeBoard;
import com.springapp.mvc.StepJumper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by Vishal Joshi on 19/2/15.
 */
@Service
public class SnakeBoardServiceImpl implements SnakeBoardService {
    private SnakeBoard snakeBoard;

    public SnakeBoardServiceImpl(SnakeBoard snakeBoard){
        this.snakeBoard = snakeBoard;
    }

    @Override
    public boolean isLadder(int step) {
        for (Ladder ladder : snakeBoard.getLadders()) {
            if(ladder.getStartStep() == step){
                return true;
            }
        }
        return false;
    }

    @Override
    public Ladder getLadder(int step) {
        if(CollectionUtils.isNotEmpty(snakeBoard.getLadders())){
            for (Ladder ladder : snakeBoard.getLadders()) {
                if(ladder.getStartStep() == step){
                    return ladder;
                }
            }
        }
        return null;
    }

    @Override
    public boolean isSnake(int step) {
        for (Snake snake : snakeBoard.getSnakes()) {
            if(snake.getMouth() == step){
                return true;
            }
        }
        return false;
    }

    @Override
    public Snake getSnake(int step) {
        if(CollectionUtils.isNotEmpty(snakeBoard.getSnakes())) {
            for (Snake snake : snakeBoard.getSnakes()) {
                if (snake.getMouth() == step) {
                    return snake;
                }
            }
        }
        return null;
    }

    @Override
    public int getDestinationStep(int step) {
        StepJumper snakeOrLadder = getStepJumperForTheStep(step);
        return snakeOrLadder != null ? snakeOrLadder.getDestinationStep(): step;
    }

    private StepJumper getStepJumperForTheStep(int step){
        Ladder ladder = getLadder(step);
        Snake snake = getSnake(step);
        if (ladder != null){
            System.out.println(String.format("A ladder with end step at %s found at %s: ",ladder.getEndStep(), step));
            return ladder;
        } else if(snake != null) {
            System.out.println(String.format("A snake with tail at %s found at %s",snake.getTail(), step));
            return snake;
        }
        return null;
    }
}
