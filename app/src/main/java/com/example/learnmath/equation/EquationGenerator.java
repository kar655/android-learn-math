package com.example.learnmath.equation;

import java.util.ArrayList;
import java.util.Random;

public class EquationGenerator {
    private static final int MAX_VALUE = 20;
    private static final int MIN_VALUE = 1;
    private static final Random random = new Random();

    private EquationGenerator() {
    }

    private static int generateNumber() {
        return random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
    }

    private static EquationPart generateMissingPart() {
        final int chosen = random.nextInt(3);

        switch (chosen) {
            case 0:
                return EquationPart.FIRST;
            case 1:
                return EquationPart.SECOND;
            default:
                return EquationPart.RESULT;
        }
    }

    private static EquationType generateType() {
        final int chosen = random.nextInt(4);

        switch (chosen) {
            case 0:
                return EquationType.ADD;
            case 1:
                return EquationType.SUB;
            case 2:
                return EquationType.MUL;
            default:
                return EquationType.DIV;
        }
    }

    public static ArrayList<Equation> generateEquations(int number) {
        final ArrayList<Equation> equations = new ArrayList<>();

        for (int i = 0; i < number; ++i) {
            int first = generateNumber();
            int second = generateNumber();
            equations.add(new Equation(
                    first,
                    second,
                    generateType(),
                    generateMissingPart()
            ));
        }

        return equations;
    }
}
