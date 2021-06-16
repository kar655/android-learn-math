package com.example.learnmath.equation;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public enum EquationType {
    ADD('+'),
    SUB('-'),
    MUL('*');


    final private char symbol;

    EquationType(char symbol) {
        this.symbol = symbol;
    }

    public static BiFunction<Integer, Integer, Integer> getFunction(EquationType type) {
        switch (type) {
            case ADD:
                return (a, b) -> a + b;
            case SUB:
                return (a, b) -> a - b;
            case MUL:
                return (a, b) -> a * b;
            default:
                throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
