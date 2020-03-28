package stringaddcalculator;

import stringaddcalculator.PositiveNumbers;

public class StringAddCalculator {
    public static int addString(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return sum(StringConverter.convertFromStringToNumbers(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(PositiveNumbers positiveNumbers) {
        return positiveNumbers.sum();
    }
}