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

    @Override
    public int rollDice(){
        //generate random number between 0 to 6nge
        boolean isValueZero = false;
        int diceResult = 0;
        do {
            diceResult = randomNumberGenerator.nextInt(6);
            if(diceResult == 0){
                isValueZero = true;
            }
        }
        while(isValueZero);

        return diceResult;
    }
}
