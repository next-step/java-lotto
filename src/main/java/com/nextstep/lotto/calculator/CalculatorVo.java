package com.nextstep.lotto.calculator;

public class CalculatorVo {
    private static final String DEFAULT_DELIMITER = "[,:]";

    private String numbers;
    private String delimiter;

    public CalculatorVo(String numbers) {
        this(numbers, DEFAULT_DELIMITER);
    }

    public CalculatorVo(String numbers, String delimiter) {
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
