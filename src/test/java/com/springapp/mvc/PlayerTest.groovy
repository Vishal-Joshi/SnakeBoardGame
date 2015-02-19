package com.springapp.mvc

import org.gmock.WithGMock
import org.junit.Test

/**
 * Created by Vishal Joshi on 19/2/15.
 */
@WithGMock
public class PlayerTest {

    @Test
    public void testShouldAllowPlayerToMoveForward(){
        def previousPosition = 1
        def currentPosition = 1
        Player player = new Player(previousPosition, currentPosition)
        def numberOfSteps = 4
        play{
            player.move(numberOfSteps)
        }
        assert player.currentPosition-player.previousPosition == numberOfSteps
    }

    @Test
    public void testShouldAllowPlayerToMoveBackward(){
        def previousPosition = 1
        def currentPosition = 6
        Player player = new Player(previousPosition, currentPosition)
        def numberOfSteps = -4
        play{
            player.move(numberOfSteps)
        }
        assert player.previousPosition-player.currentPosition == 4
    }

}
