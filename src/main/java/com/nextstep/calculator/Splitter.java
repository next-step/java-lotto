package com.nextstep.calculator;

public class Splitter {
    private static final String DEFAULT_DELIMITER = "[,:]";

    private final String numbers;
    private final String delimiter;

    public Splitter(String numbers) {
        this(numbers, DEFAULT_DELIMITER);
    }

    public Splitter(String numbers, String delimiter) {
        this.numbers = numbers;
        this.delimiter = delimiter;
    }

    public String[] split() {
        return numbers.split(delimiter);
    }
}
