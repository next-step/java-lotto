package stringcalculator;

import stringcalculator.utils.DataParser;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        String[] stringNumbers = getValidatedInput(input);

        return Arrays.stream(stringNumbers)
                .map(DataParser::parse)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static String[] getValidatedInput(String input) {
        return new String[0];
    }
}
