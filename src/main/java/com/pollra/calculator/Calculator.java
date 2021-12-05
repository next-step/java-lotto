package com.pollra.calculator;

public class Calculator {

    public Number sum(String text) {
        Decomposer decomposer = new Decomposer();
        Numbers numbers = decomposer.decompose(text);

        return numbers.sum();
    }
}