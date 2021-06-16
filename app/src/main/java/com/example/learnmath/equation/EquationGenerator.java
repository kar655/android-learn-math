package com.example.learnmath.equation;

import java.util.ArrayList;
import java.util.Random;

public class EquationGenerator {
    private static final Random random = new Random();

    private EquationGenerator() {
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
            default:
                return EquationType.MUL;
        }
    }

    public static ArrayList<Equation> generateEquations(EquationDifficulty difficulty) {
        final ArrayList<Equation> equations = new ArrayList<>();

        for (int i = 0; i < difficulty.getTests(); ++i) {
            int first = difficulty.generateNumber();
            int second = difficulty.generateNumber();
            EquationType type = generateType();

            // Prevent calculate errors
            if ((first == 0 || second == 0) && type == EquationType.MUL) {
                type = EquationType.SUB;
            }

            equations.add(new Equation(
                    first,
                    second,
                    type,
                    generateMissingPart()
            ));
        }

        return equations;
    }
}
