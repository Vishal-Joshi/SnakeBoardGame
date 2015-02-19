package com.springapp.mvc;

/**
 * Created by Vishal Joshi on 18/2/15.
 */
public class Snake {

    private int mouth;
    private int tail;

    public Snake(int mouth, int tail) {
        this.mouth = mouth;
        this.tail = tail;
    }

    public int getMouth() {
        return mouth;
    }

    public int getTail() {
        return tail;
    }
}
