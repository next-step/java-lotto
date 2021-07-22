package string_add_calculator.domain;

import util.StringUtils;

public class NaturalNumber {
    private final int number;

    private NaturalNumber(String numberString) {
        validate(numberString);
        this.number = Integer.parseInt(numberString);
    }

    private void validate(String numberString) {
        if (!StringUtils.isNaturalNumber(numberString)) {
            throw new RuntimeException("Input string is not natural number " + numberString);
        }
    }

    public static NaturalNumber of(String numberString) {
        return new NaturalNumber(numberString);
    }

    public int toInt() {
        return number;
    }
}
