package com.github.olphil99.themathgame;

public class RandomMathProblem {
    private String problem;
    private int answer;

    public RandomMathProblem() {
        int which = (int) (Math.random() * 4);
        if (which == 0) {
            Addition a = new Addition();
            problem = a.toString();
            answer = a.getSum();
        } else if (which == 1) {
            Subtraction s = new Subtraction();
            problem = s.toString();
            answer = s.getDifference();
        } else if (which == 2) {
            Multiplication m = new Multiplication();
            problem = m.toString();
            answer = m.getProduct();
        } else {
            Division d = new Division();
            problem = d.toString();
            answer = d.getQuotient();
        }
    }

    public String getProblem() {
        return problem;
    }

    public boolean checkAnswer(int maybe) {
        return (maybe == answer);
    }

    public String toString() {
        return problem;
    }
}
