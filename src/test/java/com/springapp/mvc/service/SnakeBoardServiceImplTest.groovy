package com.springapp.mvc.service

import com.springapp.mvc.Ladder
import com.springapp.mvc.Snake
import com.springapp.mvc.SnakeBoard
import org.gmock.WithGMock
import org.junit.Test

/**
 * Created by root on 19/2/15.
 */
@WithGMock
class SnakeBoardServiceImplTest {

    @Test
    public void testShouldReturnTrueIfLadderExistsOnTheParticularStep(){
        List<Snake> snakes = null
        def startStepForLadder1 = 2
        def endStepForLadder1 = 29
        Ladder ladderFrom2To29 = new Ladder(startStepForLadder1, endStepForLadder1)
        int startStepForLadder2 = 30
        int endStepForLadder2 = 58
        Ladder ladderFrom30To58 = new Ladder(startStepForLadder2, endStepForLadder2)
        List<Ladder> ladders = [ladderFrom2To29,ladderFrom30To58]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 2
        boolean isLadder
        play{
            isLadder = snakeBoardService.isLadder(stepNumber)
        }
        assert isLadder == true
    }

    @Test
    public void testShouldReturnFalseIfLadderDoesNOTExistsOnTheParticularStep(){
        List<Snake> snakes = null
        def startStepForLadder1 = 2
        def endStepForLadder1 = 29
        Ladder ladderFrom2To29 = new Ladder(startStepForLadder1, endStepForLadder1)
        int startStepForLadder2 = 30
        int endStepForLadder2 = 58
        Ladder ladderFrom30To58 = new Ladder(startStepForLadder2, endStepForLadder2)
        List<Ladder> ladders = [ladderFrom2To29,ladderFrom30To58]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 4
        boolean isLadder
        play{
            isLadder = snakeBoardService.isLadder(stepNumber)
        }
        assert isLadder == false
    }

    @Test
    public void testShouldReturnLadderForAStepIfLadderExistsForThatStep() {
        List<Snake> snakes = null
        def startStepForLadder1 = 12
        def endStepForLadder1 = 43
        Ladder ladderFrom12To43 = new Ladder(startStepForLadder1, endStepForLadder1)
        int startStepForLadder2 = 30
        int endStepForLadder2 = 58
        Ladder ladderFrom30To58 = new Ladder(startStepForLadder2, endStepForLadder2)
        List<Ladder> ladders = [ladderFrom12To43,ladderFrom30To58]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 30
        Ladder ladder
        play{
            ladder = snakeBoardService.getLadder(stepNumber)
        }
        assert ladder != null
        assert ladder == ladderFrom30To58

    }

    @Test
    public void testShouldReturnNULLForAStepIfLadderDoesNOTExistsForThatStep() {
        List<Snake> snakes = null
        def startStepForLadder1 = 12
        def endStepForLadder1 = 43
        Ladder ladderFrom12To43 = new Ladder(startStepForLadder1, endStepForLadder1)
        int startStepForLadder2 = 30
        int endStepForLadder2 = 58
        Ladder ladderFrom30To58 = new Ladder(startStepForLadder2, endStepForLadder2)
        List<Ladder> ladders = [ladderFrom12To43,ladderFrom30To58]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 31
        Ladder ladder
        play{
            ladder = snakeBoardService.getLadder(stepNumber)
        }
        assert ladder == null

    }
}
