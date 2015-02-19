package com.springapp.mvc;

/**
 * Created by Vishal Joshi on 18/2/15.
 */
public class Ladder {
    private int startStep;
    private int endStep;

    public Ladder(int startStep, int endStep) {
        this.startStep = startStep;
        this.endStep = endStep;
    }


    public int getStartStep() {
        return startStep;
    }

    public int getEndStep() {
        return endStep;
    }
}
