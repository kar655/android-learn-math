package com.example.learnmath.equation;

import java.util.Random;

public enum EquationDifficulty {
    EASY(0, 10, 3),
    MEDIUM(0, 20, 5),
    HARD(-10, 20, 10);


    private static final Random random = new Random();

    private final int minValue;
    private final int maxValue;
    private final int tests;

    EquationDifficulty(int minValue, int maxValue, int tests) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.tests = tests;
    }

    public int generateNumber() {
        return random.nextInt(maxValue - minValue) + minValue;
    }

    public int getTests() {
        return tests;
    }
}
