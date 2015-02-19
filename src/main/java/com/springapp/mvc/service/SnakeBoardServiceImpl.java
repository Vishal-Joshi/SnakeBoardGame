package com.springapp.mvc.service;

import com.springapp.mvc.Ladder;
import com.springapp.mvc.Snake;
import com.springapp.mvc.SnakeBoard;
import org.springframework.stereotype.Service;

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
        for (Ladder ladder : snakeBoard.getLadders()) {
            if(ladder.getStartStep() == step){
                return ladder;
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
        for (Snake snake : snakeBoard.getSnakes()) {
            if(snake.getMouth() == step){
                return snake;
            }
        }
        return null;
    }
}
