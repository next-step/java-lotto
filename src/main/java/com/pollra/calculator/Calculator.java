package com.pollra.calculator;

/**
 * @since       2021.11.27
 * @author      pollra
 **********************************************************************************************************************/
public class Calculator {

    public Number sum(String text) {
        Decomposer decomposer = new Decomposer();
        Numbers numbers = decomposer.decompose(text);

        return numbers.sum();
    }
}