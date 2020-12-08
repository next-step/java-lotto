package com.nextstep.lotto.calculator;

public class CalculatorItem {
    private static final String DEFAULT_DELIMITER = "[,:]";

    private String numbers;
    private String delimiter;

    public CalculatorItem(String numbers) {
        this(numbers, DEFAULT_DELIMITER);
    }

    public CalculatorItem(String numbers, String delimiter) {
        this.numbers = numbers;
        this.delimiter = delimiter;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
