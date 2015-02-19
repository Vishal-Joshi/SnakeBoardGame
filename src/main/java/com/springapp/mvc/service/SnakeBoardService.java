package com.springapp.mvc.service;

import com.springapp.mvc.Ladder;
import com.springapp.mvc.Snake;
import groovy.lang.Closure;

/**
 * Created by root on 19/2/15.
 */
public interface SnakeBoardService {

    boolean isLadder(int step);

    Ladder getLadder(int step);

    boolean isSnake(int step);

    Snake getSnake(int step);
}
