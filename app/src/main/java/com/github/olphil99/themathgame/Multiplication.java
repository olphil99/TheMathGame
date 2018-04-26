package com.github.olphil99.themathgame;

public class Multiplication {
    private int multiplicand, multiplier, product;

    public Multiplication() {
        multiplicand = (int) (Math.random() * 100);
        multiplier = (int) (Math.random() * 100);
        product = this.getProduct();
    }

    public int getMultiplicand() {
        return multiplicand;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int getProduct() {
        return product = multiplicand * multiplier;
    }

    public String toString() {
        return multiplicand + " x " + multiplier + " = ";
    }
}
