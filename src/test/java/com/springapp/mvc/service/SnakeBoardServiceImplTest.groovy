package com.springapp.mvc.service

import com.springapp.mvc.Ladder
import com.springapp.mvc.Snake
import com.springapp.mvc.SnakeBoard
import org.gmock.WithGMock
import org.junit.Test

/**
 * Created by Vishal Joshi on 19/2/15.
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

    @Test
    public void testShouldReturnTrueIfSnakeExistsOnTheParticularStep(){
        List<Ladder> ladders = null
        def mouthForSnake1 = 30
        def tailForSnake1 = 11
        Snake snakeFrom30to11 = new Snake(mouthForSnake1, tailForSnake1)
        int mouthForSnake2 = 99
        int tailForSnake2 = 6
        Snake snakeFrom98To6 = new Snake(mouthForSnake2, tailForSnake2)
        List<Snake> snakes = [snakeFrom30to11,snakeFrom98To6]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 30
        boolean isSnake
        play{
            isSnake = snakeBoardService.isSnake(stepNumber)
        }
        assert isSnake == true
    }

    @Test
    public void testShouldReturnFalseIfSnakeDoesNotExistsOnTheParticularStep(){
        List<Ladder> ladders = null
        def mouthForSnake1 = 30
        def tailForSnake1 = 11
        Snake snakeFrom30to11 = new Snake(mouthForSnake1, tailForSnake1)
        int mouthForSnake2 = 99
        int tailForSnake2 = 6
        Snake snakeFrom98To6 = new Snake(mouthForSnake2, tailForSnake2)
        List<Snake> snakes = [snakeFrom30to11,snakeFrom98To6]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 32
        boolean isSnake
        play{
            isSnake = snakeBoardService.isSnake(stepNumber)
        }
        assert isSnake == false
    }

    @Test
    public void testShouldReturnTheSnakeIfSnakeExistsOnTheParticularStep(){
        List<Ladder> ladders = null
        def mouthForSnake1 = 30
        def tailForSnake1 = 11
        Snake snakeFrom30to11 = new Snake(mouthForSnake1, tailForSnake1)
        int mouthForSnake2 = 99
        int tailForSnake2 = 6
        Snake snakeFrom98To6 = new Snake(mouthForSnake2, tailForSnake2)
        List<Snake> snakes = [snakeFrom30to11,snakeFrom98To6]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 30
        Snake snake
        play{
            snake = snakeBoardService.getSnake(stepNumber)
        }
        assert snake != null
        assert snake == snakeFrom30to11
    }

    @Test
    public void testShouldReturnNULLIfNoSnakeExistsOnTheParticularStep(){
        List<Ladder> ladders = null
        def mouthForSnake1 = 30
        def tailForSnake1 = 11
        Snake snakeFrom30to11 = new Snake(mouthForSnake1, tailForSnake1)
        int mouthForSnake2 = 99
        int tailForSnake2 = 6
        Snake snakeFrom98To6 = new Snake(mouthForSnake2, tailForSnake2)
        List<Snake> snakes = [snakeFrom30to11,snakeFrom98To6]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 32
        Snake snake
        play{
            snake = snakeBoardService.getSnake(stepNumber)
        }
        assert snake == null
    }

    @Test
    public void testShouldReturnLaddersEndStepIfTheStepHasLadderOnIt(){
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
        int destinationStep
        play{
            destinationStep = snakeBoardService.getDestinationStep(stepNumber)
        }
        assert destinationStep == ladderFrom30To58.endStep
    }

    @Test
    public void testShouldReturnSnakesTailStepIfTheStepHasSnakeOnIt(){
        List<Ladder> ladders = null
        def mouthForSnake1 = 30
        def tailForSnake1 = 11
        Snake snakeFrom30to11 = new Snake(mouthForSnake1, tailForSnake1)
        int mouthForSnake2 = 99
        int tailForSnake2 = 6
        Snake snakeFrom98To6 = new Snake(mouthForSnake2, tailForSnake2)
        List<Snake> snakes = [snakeFrom30to11,snakeFrom98To6]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 30
        def destinationStep
        play{
            destinationStep = snakeBoardService.getDestinationStep(stepNumber)
        }
        assert destinationStep == snakeFrom30to11.tail
    }

    @Test
    public void testShouldReturnTheOriginalStepIfNoSnakeOrLadderWasFound(){
        def startStepForLadder1 = 12
        def endStepForLadder1 = 43
        Ladder ladderFrom12To43 = new Ladder(startStepForLadder1, endStepForLadder1)
        int startStepForLadder2 = 30
        int endStepForLadder2 = 58
        Ladder ladderFrom30To58 = new Ladder(startStepForLadder2, endStepForLadder2)
        List<Ladder> ladders = [ladderFrom12To43,ladderFrom30To58]
        def mouthForSnake1 = 30
        def tailForSnake1 = 11
        Snake snakeFrom30to11 = new Snake(mouthForSnake1, tailForSnake1)
        int mouthForSnake2 = 99
        int tailForSnake2 = 6
        Snake snakeFrom98To6 = new Snake(mouthForSnake2, tailForSnake2)
        List<Snake> snakes = [snakeFrom30to11,snakeFrom98To6]
        def snakeBoard = new SnakeBoard(snakes, ladders)
        SnakeBoardService snakeBoardService = new SnakeBoardServiceImpl(snakeBoard)
        def stepNumber = 8
        def destinationStep
        play{
            destinationStep = snakeBoardService.getDestinationStep(stepNumber)
        }
        assert destinationStep == stepNumber
    }
}
