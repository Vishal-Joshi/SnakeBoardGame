package com.springapp.mvc.service

import com.springapp.mvc.Player
import org.gmock.WithGMock
import org.junit.Test

/**
 * Created by Vishal Joshi on 19/2/15.
 */
@WithGMock
public class PlayerServiceImplTest {

    @Test
    public void testShouldReturnAPlayer(){
        PlayerService playerService = new PlayerServiceImpl()
        Player player
        play{
            player = playerService.getPlayer()
        }
        assert player != null
    }

    @Test
    public void testShouldReturnTheSamePlayerOnceANewPlayerIsMade(){
        PlayerService playerService = new PlayerServiceImpl()
        Player playerObtainedAtFirstHit
        Player playerObtainedAtSecondHit
        play{
            playerObtainedAtFirstHit = playerService.getPlayer()
            playerObtainedAtSecondHit = playerService.getPlayer()
        }
        assert playerObtainedAtFirstHit == playerObtainedAtSecondHit
    }
}
