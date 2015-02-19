package com.springapp.mvc.service;

import com.springapp.mvc.Player;
import org.springframework.stereotype.Service;

/**
 * Created by Vishal Joshi on 19/2/15.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    private static Player player;
    @Override
    public Player getPlayer() {
        // make only one player object to persist state of player as
        // I am not using any persisting layer like database
        if(player==null){
            player = new Player(1,1);
            return player;
        }
        return player;
    }
}
