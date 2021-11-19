package calculator;

import calculator.domain.InputValue;
import calculator.domain.SeparatedValues;

public class StringAddCalculator {
    private static final int NUMBER_ZERO = 0;

    private SeparatedValues separatedValues;

    public int splitAndSum(InputValue inputValue) {
        if (inputValue.isNullOrBlank()) {
            return NUMBER_ZERO;
        }

        if (inputValue.isOneLengthOnlyNumber()) {
            return Integer.parseInt(inputValue.getInputStringValue());
        }

        if (inputValue.isCommaOrColonSeparator()) {
            separatedValues = new SeparatedValues(inputValue.getSeparatedValuesByCommaOrColon());
        }

        if (inputValue.isCustomSeparator()) {
            separatedValues = new SeparatedValues(inputValue.getSeparatedValuesByCustom());
        }

        separatedValues.checkMinusValues();

        return separatedValues.calculateSum();
    }
}
