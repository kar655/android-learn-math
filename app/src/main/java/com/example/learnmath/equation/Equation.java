package com.example.learnmath.equation;

import java.io.Serializable;

public class Equation implements Serializable {
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

    private String toStringReplaceEmpty(String replacement) {
        StringBuilder stringBuilder = new StringBuilder();

        if (removed == EquationPart.FIRST) {
            stringBuilder.append(replacement);
        } else {
            stringBuilder.append(first);
        }

        stringBuilder.append(' ').append(type.toString()).append(' ');

        if (removed == EquationPart.SECOND) {
            stringBuilder.append(replacement);
        } else {
            stringBuilder.append(second);
        }

        stringBuilder.append(" = ");

        if (removed == EquationPart.RESULT) {
            stringBuilder.append(replacement);
        } else {
            stringBuilder.append(result);
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return toStringReplaceEmpty("_");
    }

    private int getMissing() {
        if (removed == EquationPart.FIRST) {
            return first;
        } else if (removed == EquationPart.SECOND) {
            return second;
        } else {
            return result;
        }
    }

    public String getResult() {
        return correct ? "Success! " + chosen + " is correct!"
                : "Passed value " + chosen + " is not correct.\n" + getMissing() + " was expected.";
    }

    public String getSummaryString() {
        return toStringReplaceEmpty(String.valueOf(chosen)) + " is " + (correct ? "correct!"
                : "wrong, expected " + toStringReplaceEmpty(String.valueOf(getMissing())));
    }

    public void makeGuess(int value) {
        chosen = value;
        correct = getMissing() == chosen;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getChosen() {
        return chosen;
    }
}
