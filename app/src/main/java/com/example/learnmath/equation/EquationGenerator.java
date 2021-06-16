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
            case 2:
                return EquationType.MUL;
            default:
                return EquationType.DIV;
        }
    }

    public static ArrayList<Equation> generateEquations(EquationDifficulty difficulty) {
        final ArrayList<Equation> equations = new ArrayList<>();

        for (int i = 0; i < difficulty.getTests(); ++i) {
            int first = difficulty.generateNumber();
            int second = difficulty.generateNumber();
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
