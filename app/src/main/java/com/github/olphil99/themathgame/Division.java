package com.github.olphil99.themathgame;

public class Division {
    private int dividend, divisor, quotient;

    public Division() {
        this.setDivisor();
        this.setDividend();
        quotient = this.getQuotient();
    }

    private void setDividend() {
        dividend = (divisor) * ((int) (Math.random() * 12 + 1));
    }

    private void setDivisor() {
        divisor = (int) (Math.random() * 12 + 1);
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient = dividend / divisor;
    }

    public String toString() {
        return dividend + " / " + divisor;
    }
}
