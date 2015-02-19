package com.springapp.mvc.service

import org.gmock.WithGMock
import org.junit.Test

/**
 * Created by root on 19/2/15.
 */
@WithGMock
public class RandomRollableDiceTest {

    @Test
    public void testRollDice() {
        //given
        RollableDice randomRollableDice = new RandomRollableDice()
        int result = 0
        //when
        play{
            result = randomRollableDice.rollDice()
        }
        //then
        assert result != 0;
    }
}
