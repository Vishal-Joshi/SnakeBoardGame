package com.springapp.mvc.controller

import com.springapp.mvc.Ladder
import com.springapp.mvc.Player
import com.springapp.mvc.Snake
import com.springapp.mvc.service.PlayerService
import com.springapp.mvc.service.RollableDice
import com.springapp.mvc.service.SnakeBoardService
import org.gmock.WithGMock
import org.junit.Before
import org.junit.Test

/**
 * Created by Vishal Joshi on 19/2/15.
 */
@WithGMock
public class GameControllerTest {
    private RollableDice mockRollableDice
    private SnakeBoardService mockSnakeBoardService
    private PlayerService mockPlayerService
    private GameController gameController

    @Before
    public void setUp(){
        mockRollableDice = mock(RollableDice)
        mockPlayerService = mock(PlayerService)
        mockSnakeBoardService = mock(SnakeBoardService)
        gameController = new GameController(mockPlayerService, mockRollableDice, mockSnakeBoardService)
    }

    @Test
    public void testShouldAllowPlayerToPlayDice(){
        def previousPosition = 1
        def currentPosition = 1
        def player = new Player(previousPosition, currentPosition)
        def numberOfStepsToMove = 4
        mockPlayerService.getPlayer() returns player
        mockRollableDice.rollDice() returns numberOfStepsToMove
        def newStepOfPlayerAfterMovingNumberOfStepsGivenByDice = previousPosition + numberOfStepsToMove
        mockSnakeBoardService.isLadder(newStepOfPlayerAfterMovingNumberOfStepsGivenByDice) returns false
        play{
            gameController.play()
        }

        assert player.currentPosition-player.previousPosition == numberOfStepsToMove
        assert player.currentPosition == previousPosition + numberOfStepsToMove
    }

    @Test
    public void testShouldAllowPlayerToPlayDiceAndClimbLadder(){
        def previousPosition = 1
        def currentPosition = 1
        def player = new Player(previousPosition, currentPosition)
        def numberOfStepsToMove = 4
        def newStepOfPlayerAfterMovingNumberOfStepsGivenByDice = previousPosition + numberOfStepsToMove
        def endStepOfLadder = 30
        int startStep = newStepOfPlayerAfterMovingNumberOfStepsGivenByDice
        def ladder = new Ladder(startStep, endStepOfLadder)
        mockPlayerService.getPlayer() returns player
        mockRollableDice.rollDice() returns numberOfStepsToMove
        mockSnakeBoardService.isLadder(newStepOfPlayerAfterMovingNumberOfStepsGivenByDice) returns true
        mockSnakeBoardService.getLadder(newStepOfPlayerAfterMovingNumberOfStepsGivenByDice) returns ladder
        play{
            gameController.play()
        }

        assert player.currentPosition == ladder.endStep
    }

    @Test
    public void testShouldAllowPlayerToPlayDiceAndFallToSnakedTailIfLandedOnSnakeStep(){
        def previousPosition = 1
        def currentPosition = 1
        def player = new Player(previousPosition, currentPosition)
        def numberOfStepsToMove = 4
        def newStepOfPlayerAfterMovingNumberOfStepsGivenByDice = previousPosition + numberOfStepsToMove
        def tail = 2
        int mouth = newStepOfPlayerAfterMovingNumberOfStepsGivenByDice
        def snake = new Snake(mouth, tail)
        mockPlayerService.getPlayer() returns player
        mockRollableDice.rollDice() returns numberOfStepsToMove
        mockSnakeBoardService.isLadder(newStepOfPlayerAfterMovingNumberOfStepsGivenByDice) returns false
        mockSnakeBoardService.isSnake(newStepOfPlayerAfterMovingNumberOfStepsGivenByDice) returns true
        mockSnakeBoardService.getSnake(newStepOfPlayerAfterMovingNumberOfStepsGivenByDice) returns snake
        play{
            gameController.play()
        }

        assert player.currentPosition == tail
    }
}
