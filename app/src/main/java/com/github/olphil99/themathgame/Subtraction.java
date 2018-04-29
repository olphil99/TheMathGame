package com.github.olphil99.themathgame;

public class Subtraction {
    private int minuend, subtrahend, difference;

    public Subtraction() {
        minuend = (int) (Math.random() * 100);
        subtrahend = (int) (Math.random() * 100);
        difference = this.getDifference();
    }

    public int getMinuend() {
        return minuend;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    public int getDifference() {
        return difference = minuend - subtrahend;
    }

    public String toString() {
        return minuend + " - " + subtrahend;
    }
}
