package com.springapp.mvc;

/**
 * Created by Vishal Joshi on 18/2/15.
 */
public class Player {

    private int previousPosition;
    private int currentPosition;

    public Player(int previousPosition, int currentPosition){
        this.previousPosition = previousPosition;
        this.currentPosition = currentPosition;
    }

    public int getPreviousPosition() {
        return previousPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(final int numberOfSteps){
        this.previousPosition = this.currentPosition;
        this.currentPosition += numberOfSteps;
    }

}

