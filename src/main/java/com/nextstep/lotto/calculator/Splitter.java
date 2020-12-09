package com.nextstep.lotto.calculator;

public class Splitter {
    private static final String DEFAULT_DELIMITER = "[,:]";

    private String numbers;
    private String delimiter;

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
