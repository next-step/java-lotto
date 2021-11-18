package calculator;

import calculator.domain.InputValue;

import java.util.List;

public class StringAddCalculator {
    private static final int NUMBER_ZERO = 0;

    private int resultValue;
    private List<String> separatedValues;

    public int splitAndSum(InputValue inputValue) {
        if (inputValue.isNullOrBlank()) {
            return NUMBER_ZERO;
        }

        if (inputValue.isOneLengthOnlyNumber()) {
            return Integer.parseInt(inputValue.getInputStringValue());
        }

        if (inputValue.isCommaSeparator()) {
            separatedValues = inputValue.getSeparatedValuesByComma();
        }

        return separatedValues.stream()
                .mapToInt(value -> Integer.parseInt(value)).sum();

    }
}
