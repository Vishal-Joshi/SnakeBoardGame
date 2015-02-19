package com.springapp.mvc.service;

import com.springapp.mvc.Ladder;

/**
 * Created by root on 19/2/15.
 */
public interface SnakeBoardService {

    boolean isLadder(int step);

    Ladder getLadder(int diceResult);
}
