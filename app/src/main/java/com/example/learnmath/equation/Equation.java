package com.example.learnmath.equation;

public class Equation {
    private final int first;
    private final int second;
    private final int result;
    private final EquationType type;
    private final EquationPart removed;
    private int chosen;
    private boolean correct;


    public Equation(int first, int second, EquationType type, EquationPart removed) {
        this.first = first;
        this.second = second;
        this.type = type;
        this.removed = removed;

        this.result = EquationType.getFunction(this.type).apply(this.first, this.second);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (removed == EquationPart.FIRST) {
            stringBuilder.append('_');
        } else {
            stringBuilder.append(first);
        }

        stringBuilder.append(' ').append(type.toString()).append(' ');

        if (removed == EquationPart.SECOND) {
            stringBuilder.append('_');
        } else {
            stringBuilder.append(second);
        }

        stringBuilder.append(" = ");

        if (removed == EquationPart.RESULT) {
            stringBuilder.append('_');
        } else {
            stringBuilder.append(result);
        }

        return stringBuilder.toString();
    }

    public void makeGuess(int value) {
        chosen = value;

        if (removed == EquationPart.FIRST) {
            correct = first == chosen;
        } else if (removed == EquationPart.SECOND) {
            correct = second == chosen;
        } else {
            correct = result == chosen;
        }
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getChosen() {
        return chosen;
    }
}
