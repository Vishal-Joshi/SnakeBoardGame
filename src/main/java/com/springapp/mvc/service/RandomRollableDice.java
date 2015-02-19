package com.springapp.mvc.service;

import com.springapp.mvc.service.RollableDice;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Vishal Joshi on 18/2/15.
 */
@Service
public class RandomRollableDice implements RollableDice {
    private Random randomNumberGenerator = new Random();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 6;

    @Override
    public int rollDice(){
        //generate random number between 0 to 6nge
        boolean isValueZero = false;
        int diceResult = 0;
        do {
            diceResult = randomNumberGenerator.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            if(diceResult == 0){
                isValueZero = true;
            }
        }
        while(isValueZero);

        return diceResult;
    }
}
