package com.github.olphil99.themathgame;

public class Addition {
    private int augend, addend, sum;

    public Addition() {
        augend = (int) (Math.random() * 12);
        addend = (int) (Math.random() * 12);
        sum = this.getSum();
    }

    public int getAugend() {
        return augend;
    }

    public int getAddend() {
        return addend;
    }

    public int getSum() {
        return sum = augend + addend;
    }

    public String toString() {
        return augend + " + " + addend;
    }
}
