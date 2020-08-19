package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static String DELIMITER = ",|:";
    private final static int ZERO = 0;
    private final static int MINUS_VALUE = -1;
    private final static int LENGTH_ONE = 1;


    static int splitAndSum(String input) {
        if (validateInputNUll(input)) return 0;
        if (validateInputOneNumber(input)) return Integer.parseInt(input);

        int returnValue = hasCustomDelimiter(input);
        if (returnValue >= ZERO) return returnValue;

        String[] inputs = input.split(DELIMITER);
        validateInputNegative(inputs);
        return elementSum(inputs);
    }

    private static void validateInputNegative(String[] inputs) {
        boolean isAllPostiveValue = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(element -> element >= ZERO);

        if (!isAllPostiveValue) {
            throw new RuntimeException("ERR!!!");
        }
    }

    private static int hasCustomDelimiter(String input) {
        System.out.println(input);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String inputs[] = m.group(2).split(customDelimiter);
            return elementSum(inputs);
        }

        return MINUS_VALUE;
    }

    private static boolean validateInputOneNumber(String input) {
        if (input.length() == LENGTH_ONE) {
            return true;
        }
        return false;
    }

    private static boolean validateInputNUll(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private static int elementSum(String inputs[]) {
        int sum = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return sum;
    }
}


